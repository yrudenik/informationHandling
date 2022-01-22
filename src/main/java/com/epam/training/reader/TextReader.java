package com.epam.training.reader;

import com.epam.training.exception.CustomComponentException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

    public String read(String filepath) throws CustomComponentException {
        if (filepath == null || filepath.isEmpty()) {
            throw new CustomComponentException("Filepath is null or incorrect");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filepath);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new CustomComponentException("File can not be opened: ", e);
        }
        return stringBuilder.toString().trim();
    }

}
