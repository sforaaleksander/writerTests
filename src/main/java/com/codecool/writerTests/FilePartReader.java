package com.codecool.writerTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        setup("", 1, 1);
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1 || toLine < fromLine) {
            throw new IllegalArgumentException("Invalid arguments passed for reading lines");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String getLines() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readLines() throws IOException {
        String[] lines = getLines().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        int validToLine = Math.min(toLine, lines.length);
        for (int i = fromLine; i <= validToLine; i++) {
            stringBuilder.append(lines[i - 1]).append("\n");
        }
        return stringBuilder.toString();
    }

    public String accessGetLines() throws IOException {
        return getLines();
    }
}


