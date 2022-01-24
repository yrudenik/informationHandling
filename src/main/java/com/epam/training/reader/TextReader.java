package com.epam.training.reader;

import com.epam.training.exception.CustomComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

    private static final Logger LOGGER = LogManager.getLogger();

    public String read(String filepath) throws CustomComponentException {
        LOGGER.info("Start reading from the file");
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
