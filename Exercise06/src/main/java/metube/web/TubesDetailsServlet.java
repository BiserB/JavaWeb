package metube.web;

import metube.models.view.TubeFullViewModel;
import metube.services.TubeService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/details")
public class TubesDetailsServlet extends BaseServlet {

    @Inject
    protected TubesDetailsServlet(TubeService service) {
        super(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");

        TubeFullViewModel model =  getService().getByTitle(title);

        req.setAttribute("model", model);

        req.getRequestDispatcher("/www/tubes-details.jsp").forward(req, resp);
    }
}
