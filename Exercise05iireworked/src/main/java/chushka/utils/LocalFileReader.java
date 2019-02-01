package chushka.utils;

import java.io.*;

public class LocalFileReader {

    public String read(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();

        File fileName = new File(filePath);

        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {

            content.append(line);
        }

        bufferedReader.close();

        return content.toString();
    }
}
