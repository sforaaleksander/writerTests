package com.codecool.writerTests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;
    private List<String> words;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        getWords(filePartReader);
    }

    private void getWords(FilePartReader filePartReader) {
        try {
            words = Arrays.asList(filePartReader.readLines().split("\\s+"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsOrderedAlphabetically () {
        return words.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring (String subString) {
        return words.stream().filter(s -> s.contains(subString)).collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes () {
        return words.stream().filter(this::checkIfPalindrome).collect(Collectors.toList());
    }

    private Boolean checkIfPalindrome(String string) {
        if (string.length()==1) {
            return false;
        }
        string = string.toLowerCase();
        char[] letters = string.toCharArray();
        int wordLength = letters.length;
        for (char letter : letters) {
            if (letter != letters[--wordLength]) {
                return false;
            }
        }
        return true;
    }
}
