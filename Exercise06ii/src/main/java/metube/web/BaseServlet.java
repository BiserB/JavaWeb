package metube.web;

import metube.services.TubeService;
import metube.utils.ResourcesFileReader;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    private final TubeService service;

    protected BaseServlet(TubeService service) {
        this.service = service;
    }

    public TubeService getService() {
        return service;
    }
}
