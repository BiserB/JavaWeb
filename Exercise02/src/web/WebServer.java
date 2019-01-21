package web;

import java.util.ArrayList;
import java.util.List;

public class WebServer {

    private List<String> paths;

    public WebServer() {
        this.paths = new ArrayList<>();
    }

    public void setPaths(List<String> paths){

        if (paths == null){
            throw new IllegalArgumentException("Invalid WebServer paths");
        }

        this.paths = paths;
    }

    public boolean isValidPath(String path){
        return this.paths.contains(path);
    }
}
