package web.contracts;

import java.util.HashMap;

public interface HttpRequest {

    String getProtocol();

    HashMap<String, String> getHeaders();

    HashMap<String, String> getCookies();

    HashMap<String, String> getBodyParameters();

    String getMethod();

    void setMethod(String method);

    String getRequestUrl();

    void setRequestUrl(String requestUrl);

    void addHeader(String header, String value);

    void addBodyParameter(String parameter, String value);
}
