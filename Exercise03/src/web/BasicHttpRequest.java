package web;

import web.contracts.HttpRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BasicHttpRequest implements HttpRequest {

    private String protocol;
    private String method;
    private String requestUrl;
    private HashMap<String, String> headers;
    private HashMap<String, String> cookies;
    private HashMap<String, String> bodyParams;

    public BasicHttpRequest(String protocol, String method, String requestUrl) {
        this.setProtocol(protocol);
        this.setMethod(method);
        this.setRequestUrl(requestUrl);
        this.headers = new LinkedHashMap<>();
        this.cookies = new LinkedHashMap<>();
        this.bodyParams = new LinkedHashMap<>();
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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
    public HashMap<String, String> getHeaders() {
        return new LinkedHashMap<>(this.headers);
    }

    @Override
    public HashMap<String, String> getCookies() {

        String cookieHeader = headers.get("Cookie");

        if(cookieHeader != null){

            String[] pairs = cookieHeader.split("; ");

            for (String pair: pairs ) {

                String[] data = pair.trim().split("=");

                String name = data[0];
                String value = data[1];

                cookies.put(name, value);
            }
        }

        return this.cookies;
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
    public HashMap<String, String> getBodyParameters() {
        return new LinkedHashMap<>(this.bodyParams);
    }
}
