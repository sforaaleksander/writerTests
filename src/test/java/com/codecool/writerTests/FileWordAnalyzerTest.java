package com.codecool.writerTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @Mock
    static private FilePartReader filePartReader;

    @BeforeEach
    public void init() throws IOException {
//        FilePartReader filePartReader = new FilePartReader();
//        filePartReader.setup("src/test/java/com/codecool/writerTests/test.txt", 1, 1);
//        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        filePartReader = mock(FilePartReader.class);
        when(filePartReader.readLines()).thenReturn("test txt file");
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void getWordsOrderedAlphabetically_TestFile_RightOrder(){
        List<String> result = new ArrayList<>(Arrays.asList("file", "test", "txt"));
        assertEquals(result, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void getWordsContainingSubstring_TestFile_Test(){
        List<String> result = new ArrayList<>(Collections.singletonList("test"));
        assertEquals(result, fileWordAnalyzer.getWordsContainingSubstring("est"));
    }

    @Test
    public void getStringsWhichPalindromes_TestFile_Txt(){
        List<String> result = new ArrayList<>(Collections.singletonList("txt"));
        assertEquals(result, fileWordAnalyzer.getStringsWhichPalindromes());
    }



}