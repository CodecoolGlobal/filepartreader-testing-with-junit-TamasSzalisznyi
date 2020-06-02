import com.codecool.reader.FilePartReader;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


class FilePartReaderTest {
    private FilePartReader fpr;
    String testString;
 
    void setupFilePartReaderForTest() {
        this.fpr = new FilePartReader();
        this.fpr.setup("/home/tamas/projects/filepartreader-testing-with-junit-TamasSzalisznyi/testStringFile.txt", 1, 3);
    }
    
    @Test
    void testRead() throws IOException {
        this.setupFilePartReaderForTest();
        this.testString = this.fpr.read();
        assertEquals("first test string\nsecond test string\nthird test string\nfourth test string\n", this.testString);
    }
    
    @Test
    void testReadLines() throws IOException {
        this.setupFilePartReaderForTest();
        this.testString = this.fpr.readLines();
        assertEquals("first test string\nsecond test string\nthird test string\n", this.testString);
    }
}
