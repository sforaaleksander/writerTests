package com.codecool.writerTests;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader filePartReader;

    @BeforeEach
    public void init() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void setup_InvalidArgument_ThrowException() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("", 0, -1));
    }

    @Test
    public void readLines_TestFile_TestFileTxt() throws IOException {
        filePartReader.setup("src/test/java/com/codecool/writerTests/test.txt", 1, 1);
        assertEquals("test txt file\n", filePartReader.readLines());
    }

    @Test
    public void getLines_TestFile_TestFileTxt() throws IOException {
        filePartReader.setup("src/test/java/com/codecool/writerTests/test.txt", 1, 1);
        assertEquals("test txt file", filePartReader.accessGetLines());
    }
}