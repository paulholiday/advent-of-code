package org.paulholiday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    List<Integer> getFileContentsByLine(String filePath) {
        List<Integer> fileContentsByLine = new ArrayList<>();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found " + filePath, e);
        }

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    fileContentsByLine.add(Integer.parseInt(line));
                }
            } catch (IOException e) {
                LOGGER.error("Error reading from file " + filePath, e);
            }
        }

        return fileContentsByLine;
    }
}