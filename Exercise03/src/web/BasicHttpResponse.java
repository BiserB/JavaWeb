package web;

import web.contracts.HttpResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class BasicHttpResponse implements HttpResponse {

    private static final Map<Integer, String> CODES = new HashMap<Integer, String>(){{
        put(200, "OK");
        put(400, "Bad Request");
        put(401, "Unauthorized");
        put(404, "Not Found");
    }};

    private String protocol;
    private int statusCode;
    private HashMap<String, String> headers;

    private String content;

    public BasicHttpResponse(String protocol) {
        this.setProtocol(protocol);
        this.headers = new LinkedHashMap<>();
    }

    private void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return new HashMap<>(this.headers);
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return content.getBytes();
    }

    @Override
    public byte[] getBytes() {

        return toString().getBytes();
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header,value);
    }

    public String toString(){

        StringBuilder result = new StringBuilder();

        String statusMsg = CODES.get(statusCode);

         result.append(protocol + " " + statusCode + " " + statusMsg + System.lineSeparator());

        for (String key: headers.keySet()) {

            result.append(key + ": " + headers.get(key) + System.lineSeparator());
        }

        result.append(System.lineSeparator());

        result.append(content).append(System.lineSeparator());

        return  result.toString();
    }
}
