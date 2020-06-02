package com.codecool.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;
    
    public FilePartReader() {
        filePath = "some invalid default value";
        fromLine = 0;
        toLine = -1;
    }
    
    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.setFilePath(filePath);
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine should be above 1");
        } else {
            this.setFromLine(fromLine - 1);
            if (toLine < this.getFromLine()) {
                throw new IllegalArgumentException("toLine should be greater than fromLine");
            } else {
                this.setToLine(toLine);
            }
        }
    }
    
    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(this.getFilePath()))) {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    
    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.read().split(System.lineSeparator());
        
        for (int i = this.getFromLine(); i < this.getToLine(); ++i) {
            sb.append(strArr[i]).append(System.lineSeparator());
        }
        
        return sb.toString();
    }
    
    private String getFilePath() {
        return this.filePath;
    }
    
    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    private Integer getFromLine() {
        return this.fromLine;
    }
    
    private void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }
    
    private Integer getToLine() {
        return this.toLine;
    }
    
    private void setToLine(Integer toLine) {
        this.toLine = toLine;
    }
}
