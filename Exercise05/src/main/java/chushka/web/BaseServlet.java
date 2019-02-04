package chushka.web;

import chushka.services.ProductService;
import chushka.utils.ResourcesFileReader;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    private final ProductService service;
    private final ResourcesFileReader reader;
    private final String content;

    protected BaseServlet(ProductService service, ResourcesFileReader reader) {
        this.service = service;
        this.reader = reader;
        this.content = getView();
    }

    public ProductService getService() {
        return service;
    }

    public String getContent() {
        return content;
    }

    private String getView(){

        String fileContent = null;

        try{
            fileContent = this.reader.read(getViewPath());
        }
        catch (IOException ex){
            // fileContent = serverError
        }

        return fileContent;
    }

    protected abstract String getViewPath();
}
