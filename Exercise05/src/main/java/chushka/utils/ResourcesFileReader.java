package chushka.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesFileReader {

    public String read(String fileDirectory) throws IOException {

      URL resource = getClass().getClassLoader().getResource(fileDirectory);

      File file = null;

        try{
            Path path = Paths.get(resource.toURI());

            file = path.toFile();
        }
        catch (URISyntaxException ex){

            throw new IOException(ex.getMessage());
        }

        FileReader fileReader = new FileReader(file);

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
