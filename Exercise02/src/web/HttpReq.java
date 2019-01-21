package web;

import web.contracts.HttpRequest;

import java.util.HashMap;

public class HttpReq implements HttpRequest {

    String method;
    String requestUrl;
    HashMap<String, String> headers;
    HashMap<String, String> bodyParams;


    public HttpReq(String method, String requestUrl) {
        this.method = method;
        this.requestUrl = requestUrl;
        this.headers = new HashMap<>();
        this.bodyParams = new HashMap<>();
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return new HashMap<>(this.headers);
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return new HashMap<>(this.bodyParams);
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {

        this.method = method;
    }

    @Override
    public String getRequestUrl() {

        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {

        this.requestUrl = requestUrl;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParams.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return false;
    }
}
