import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

import com.codecool.reader.FilePartReader;

class FilePartReaderTest {
    
    private FilePartReader fpr;
    String testString;
    
    void setupFilePartReaderForTest() {
        fpr = new FilePartReader();
        fpr.setup("/home/tamas/projects/filepartreader-testing-with-junit-TamasSzalisznyi/testStringFile.txt", 1, 3);
    }
    
    @Test
    void testRead() throws IOException {
        setupFilePartReaderForTest();
        testString = fpr.read();
        assertEquals("first line of test\nsecond line\nthird line\nfourth line\n", testString);
    }
    @Test
    void testReadLines() throws IOException {
        setupFilePartReaderForTest();
        testString = fpr.readLines();
        assertEquals("first line of test\nsecond line\nthird line\n", testString);
    }
    
}