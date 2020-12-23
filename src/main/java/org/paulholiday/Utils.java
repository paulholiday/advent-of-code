package org.paulholiday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Utils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    List<String> getFileContentsByLine(String filePath) {
        List<String> fileContentsByLine = new ArrayList<>();

        InputStream inputStream = getInputStream(filePath);
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    fileContentsByLine.add(line);
                }
            } catch (IOException e) {
                LOGGER.error("Error reading from file " + filePath, e);
            }
        }

        return fileContentsByLine;
    }

    InputStream getInputStream(String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found " + filePath, e);
        }
        return null;
    }

    char[][] getMap(List<String> fileContents) {

        char[][] map = new char[fileContents.size()][fileContents.size() * 7];

        for (int i = 0; i < fileContents.size(); i++) {
            String line = fileContents.get(i);
            for (int j = 0, k = 0; j < fileContents.size() * 7; j++, k++) {
                if (k == fileContents.get(0).length()) {
                    k = 0;
                }
                char character = line.charAt(k);
                map[i][j] = character;
            }
        }

        return map;
    }
}
