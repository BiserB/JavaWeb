package web;

import org.omg.CORBA.Request;
import web.contracts.HttpRequest;
import web.contracts.HttpResponse;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Startup {

    public static void main(String[] args) {

        WebServer webServer = new WebServer();

        RequestParser requestParser = new RequestParser(webServer);

        ResponseBuilder responseBuilder = new ResponseBuilder(webServer);

        HttpRequest request = requestParser.parse();

        String cookieArgs = request.getHeaders().get("Cookie");

        String[] pairs = cookieArgs.split(";");

        for (String pair: pairs) {

            String[] splitted = pair.trim().split("=");
            String key = splitted[0];
            String value = splitted[1];

            System.out.printf("%s <-> %s%s", key, value, System.lineSeparator());
        }
    }
}
