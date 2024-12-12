package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceFileReader {
    public List<String> readLines(String filePathName) {
        List<String> lines;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathName));
            lines = new ArrayList<>(bufferedReader.lines().skip(1).toList());
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
