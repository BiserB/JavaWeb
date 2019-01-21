package web;

import org.omg.CORBA.Request;
import web.contracts.HttpRequest;
import web.contracts.HttpResponse;

import java.util.ArrayList;
import java.util.List;

public class Startup {

    public static void main(String[] args) {

        WebServer webServer = new WebServer();

        RequestParser requestParser = new RequestParser(webServer);

        ResponseBuilder responseBuilder = new ResponseBuilder(webServer);

        HttpRequest request = requestParser.parse();

        HttpResponse response = responseBuilder.build(request);

        System.out.println(response);
    }
}
