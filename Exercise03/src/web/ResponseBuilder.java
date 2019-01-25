package web;

import web.contracts.HttpRequest;
import web.contracts.HttpResponse;

import java.util.*;

public class ResponseBuilder {

    private static final String BODY404 = "The requested functionality was not found.";
    private static final String BODY401 = "You are not authorized to access the requested functionality.";
    private static final String BODY400 = "There was an error with the requested functionality due to malformed request.";
    public static final String AUTHORIZATION = "Authorization";
    private WebServer webServer;

    public ResponseBuilder(WebServer webServer) {

        this.webServer = webServer;
    }

    public HttpResponse build(HttpRequest request) {

        if (request == null){
            throw new IllegalArgumentException("Invalid request");
        }

        HttpResponse response = new BasicHttpResponse();

        Set<String> keys = request.getHeaders().keySet();

        for (String key: keys) {
            if (!key.equalsIgnoreCase(AUTHORIZATION)){
                response.addHeader(key, request.getHeaders().get(key));
            }
        }

        if (!webServer.isValidPath(request.getRequestUrl())){
            response.setStatusCode(404);
            response.setContent(BODY404);
        }
        else if (!request.getHeaders().containsKey(AUTHORIZATION)){
            response.setStatusCode(401);
            response.setContent(BODY401);
        }
        else if (request.getMethod().equals("POST") && request.getBodyParameters().size() == 0){
            response.setStatusCode(400);
            response.setContent(BODY400);
        }
        else{
            response.setStatusCode(200);
            String content = processAithorizationAndBody(request);
            response.setContent(content);
        }

        return response;
    }

    private String processAithorizationAndBody(HttpRequest request) {

        String[] authArgs = request.getHeaders().get(AUTHORIZATION).split(" ");

        byte[] bytesDecoded = Base64.getDecoder().decode(authArgs[1]);

        String name = new String(bytesDecoded);

        HashMap<String, String> bodyParameters = request.getBodyParameters();

        if (bodyParameters.size() != 3) {
            return "";
        }

        String key1 = "", key2 = "", key3 = "", value1 = "", value2 = "", value3 = "";

        int counter = 1;

        for (String key : bodyParameters.keySet()) {

            switch (counter) {
                case 1:
                    key1 = key;
                    value1 = bodyParameters.get(key);
                    break;
                case 2:
                    key2 = key;
                    value2 = bodyParameters.get(key);
                    break;
                case 3:
                    key3 = key;
                    value3 = bodyParameters.get(key);
                    break;
            }
            counter++;
        }

        String result = String.format("Greetings %s! You have successfully created %s with %s – %s, %s – %s.",
                                                        name, value1, key2, value2, key3, value3);

        return result;

        }
}

