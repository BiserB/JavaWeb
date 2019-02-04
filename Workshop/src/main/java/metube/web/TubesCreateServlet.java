package metube.web;

import metube.models.binding.TubeBindingModel;
import metube.services.TubeService;
import metube.utils.ModelValidator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/create")
public class TubesCreateServlet extends BaseServlet {

    private final ModelValidator modelValidator;

    @Inject
    protected TubesCreateServlet(TubeService service, ModelValidator modelValidator) {
        super(service);
        this.modelValidator = modelValidator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/www/tubes-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String link = req.getParameter("link");
        String uploader = req.getParameter("uploader");

        TubeBindingModel model = new TubeBindingModel(title, description, link, uploader);

        if (!modelValidator.isValid(model)){

            req.setAttribute("msg", "Invalid tube data!");
            req.getRequestDispatcher("/www/tubes-create.jsp").forward(req, resp);
        }
        else{

            getService().save(model);

            resp.sendRedirect("/tubes/details?title=" + model.getTitle());
        }
    }
}
