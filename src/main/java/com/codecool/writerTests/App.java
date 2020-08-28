package com.codecool.writerTests;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/malville_moby.txt", 1, 9999);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> palindromes = fileWordAnalyzer.getStringsWhichPalindromes();
        for (String s : palindromes) {
            System.out.println(s);
        }
    }
}
