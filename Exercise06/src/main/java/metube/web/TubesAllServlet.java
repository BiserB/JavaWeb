package metube.web;

import metube.models.view.TubeFullViewModel;
import metube.services.TubeService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tubes/all")
public class TubesAllServlet extends BaseServlet {

    @Inject
    protected TubesAllServlet(TubeService service) {
        super(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> tubes = getService().getAllTubeTitles();

        req.setAttribute("tubes", tubes);

        req.getRequestDispatcher("/www/tubes-all.jsp").forward(req, resp);
    }
}
