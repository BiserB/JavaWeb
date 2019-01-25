package web;

import web.contracts.HttpRequest;
import web.contracts.HttpResponse;

import java.util.HashMap;


public class Startup {

    public static void main(String[] args) {

        WebServer webServer = new WebServer();

        RequestParser requestParser = new RequestParser(webServer);

        HttpRequest request = requestParser.parse();

        HashMap<String, String> cookies = request.getCookies();

        if (cookies.size() == 0){

            System.out.println("No cookies");
        }
        else{

            for (String name: cookies.keySet()) {

                System.out.println(name + " <-> " + cookies.get(name));
            }
        }
    }
}
