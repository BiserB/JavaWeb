package web.contracts;

import java.util.HashMap;

public interface HttpResponse {

    HashMap<String, String> getHeaders();

    int getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setStatusCode(int statusCode);

    void setContent(String content);

    void addHeader(String header, String value);
}
