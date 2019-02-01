package chushka.web;

import chushka.services.ProductService;
import chushka.utils.LocalFileReader;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    private final ProductService service;
    private final LocalFileReader reader;

    @Inject
    protected BaseServlet(ProductService service, LocalFileReader reader) {
        this.service = service;
        this.reader = reader;
    }

    public ProductService getService() {
        return service;
    }

    public LocalFileReader getReader() {
        return reader;
    }
}
