package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFileImpl implements ReaderFromFile {
    @Override
    public List<String> getData(String pathToFile) {
        List<String> listWithData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                listWithData.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Incorrect path to file try another path", e);
        }
        return listWithData;
    }
}