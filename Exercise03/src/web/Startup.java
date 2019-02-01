
//  Some functions are removed from previous task (Exercise 2)

package web;

import web.contracts.HttpRequest;
import java.util.HashMap;


public class Startup {

    public static void main(String[] args) {

        RequestParser requestParser = new RequestParser();

        HttpRequest request = requestParser.parse();

        HashMap<String, String> cookies = request.getCookies();

        if (cookies.size() == 0){

            System.out.println("No cookies");
        }
        else{

            for (String name: cookies.keySet()) {

                System.out.println(name + " <-> " + cookies.get(name));
            }
        }
    }
}
