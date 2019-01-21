package web;

import web.contracts.HttpRequest;
import web.contracts.HttpResponse;

public class ResponseBuilder {

    private static final String BODY404 = "The requested functionality was not found.";
    private static final String BODY401 = "You are not authorized to access the requested functionality.";
    private static final String BODY400 = "There was an error with the requested functionality due to malformed request.";
    private WebServer webServer;

    public ResponseBuilder(WebServer webServer) {

        this.webServer = webServer;
    }

    public HttpResponse build(HttpRequest request) {

        if (request == null){
            throw new IllegalArgumentException("Invalid request");
        }

        HttpResponse response = new HttpResponseBase();

        for (String key:request.getHeaders().keySet()) {
            if (!key.equalsIgnoreCase("Authorization")){
                response.addHeader(key, request.getHeaders().get(key));
            }
        }

        if (!webServer.isValidPath(request.getRequestUrl())){
            response.setStatusCode(404);
            response.setContent(BODY404);
        }
        else if (!request.getHeaders().containsKey("Authorization")){
            response.setStatusCode(401);
            response.setContent(BODY401);
        }
        else if (request.getMethod().equals("POST") && request.getBodyParameters().size() == 0){
            response.setStatusCode(400);
            response.setContent(BODY400);
        }
        else{
            response.setStatusCode(200);
            String content = "Greetings {username}! You have successfully created {firstRequestBodyParameterValue} with {secondRequestBodyParameterName} – {secondRequestBodyParameterValue}, {thirdRequestBodyParameterName} – {thirdRequestBodyParameterValue}.";
            response.setContent(content);
        }

        return response;
    }
}
