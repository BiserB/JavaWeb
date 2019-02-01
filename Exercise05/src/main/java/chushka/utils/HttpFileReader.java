package chushka.utils;

import java.io.*;

public class HttpFileReader {

    public String read(String filePath) {

        StringBuilder content = new StringBuilder();

        try {

            File fileName = new File(filePath);

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {

                content.append(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {

            System.out.println("Unable to open file '" + filePath + "'");
        }
        catch(IOException ex) {

            System.out.println("Error reading file '" + filePath + "'");
        }

        return content.toString();
    }
}
