package web;

import web.contracts.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestParser {

    HttpRequest request;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private WebServer webServer;

    public RequestParser(WebServer webServer) {
        this.webServer = webServer;
    }

    public HttpRequest parse() {

        try{
            String input = reader.readLine();

            List<String> paths = Arrays.asList(input.split(" "));

            webServer.setPaths(paths);

            input = reader.readLine();

            request = getRequestLine(input);

            while ((input = reader.readLine()) != null && input.length() > 0 ){

                getHeader(input);
            }

            while((input = reader.readLine()) != null && input.length() > 0 ){

                getRequestBody(input);
            }

            request.getHeaders();
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }

        return request;
    }

    private void getHeader(String headerLine) {

        String[] tokens = headerLine.split(": ");
        String header = tokens[0];
        String value = tokens[1];

        request.addHeader(header, value);
    }

    private HttpRequest getRequestLine(String line) {

        String[] requestLine = line.split(" ");

        if (requestLine.length != 3){
            throw new IllegalArgumentException("Invalid Request Format");
        }

        String method = requestLine[0];
        String requestUri = requestLine[1];
        String protocol = requestLine[2];

        return new HttpReq(method, requestUri);
    }

    private void getRequestBody(String input) {

        String[] pairs = input.split("&");

        for (int i = 0; i < pairs.length; i++) {

            String[] keyValues = pairs[i].split("=");

            if (keyValues.length == 2){
                request.addBodyParameter(keyValues[0], keyValues[1]);
            }
        }
    }
}
