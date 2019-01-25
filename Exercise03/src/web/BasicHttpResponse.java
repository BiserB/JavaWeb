package web;

import web.contracts.HttpResponse;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class BasicHttpResponse implements HttpResponse {

    private HashMap<String, String> headers;
    private int statusCode;
    private String content;

    public BasicHttpResponse() {
        this.headers = new LinkedHashMap<>();
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
        return new byte[0];
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
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
        String statusMsg = "OK";

        switch (statusCode){
            case 404:
                statusMsg = "Not Found";
                break;
            case 401:
                statusMsg = "Unauthorized";
                break;
            case 400:
                statusMsg = "Bad request";
                break;
        }

         result.append("HTTP/1.1 " + statusCode + " " + statusMsg + System.lineSeparator());

        for (String key: headers.keySet()) {
            result.append(key + ": " + headers.get(key) + System.lineSeparator());
        }

        result.append(System.lineSeparator());

        result.append(content).append(System.lineSeparator());

        return  result.toString();
    }
}
