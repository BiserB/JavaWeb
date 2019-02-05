package metube.web;

import metube.models.view.TubeFullViewModel;
import metube.services.TubeService;
import metube.utils.ResourcesFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/")
public class IndexServlet extends BaseServlet {

    @Inject
    public IndexServlet(TubeService service) {
        super(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/www/index.jsp").forward(req, resp);
    }

}
