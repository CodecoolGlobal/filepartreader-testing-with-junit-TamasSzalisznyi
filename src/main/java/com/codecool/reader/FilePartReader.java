package com.codecool.reader;

import java.io.*;

public class FilePartReader {
    
    private String filePath;
    private Integer fromLine;
    private Integer toLine;
    
    public FilePartReader() {
        this.filePath = "some invalid default value";
        this.fromLine = 0;
        this.toLine = -1;
    }
    
    public void setup(String filePath, Integer fromLine, Integer toLine) {
        setFilePath(filePath);
        if (fromLine < 1) throw new IllegalArgumentException("fromLine should be above 1");
        else setFromLine(fromLine - 1);
        if (toLine < getFromLine()) throw new IllegalArgumentException("toLine should be greater than fromLine");
        else setToLine(toLine);
    }
    
    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            while ((line = reader.readLine()) != null)
                sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        String[] strArr = read().split(System.lineSeparator());
        
        for (int i = getFromLine(); i < getToLine(); i ++) {
            sb.append(strArr[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    private String getFilePath() {
        return filePath;
    }
    
    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    private Integer getFromLine() {
        return fromLine;
    }
    
    private void setFromLine(Integer fromLine) {
        this.fromLine = fromLine;
    }
    
    private Integer getToLine() {
        return toLine;
    }
    
    private void setToLine(Integer toLine) {
        this.toLine = toLine;
    }
}
