package chushka.utils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalFileReader {

    public String read(String filePath) throws IOException {

        String cwd = System.getProperty("user.dir");

        File fileName = new File(filePath);

        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder content = new StringBuilder();

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {

            content.append(line);
        }

        bufferedReader.close();

        return content.toString();
    }
}
