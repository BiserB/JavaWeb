package chushka.web;

import chushka.entities.enums.Type;
import chushka.models.binding.ProductBindingModel;
import chushka.services.ProductService;
import chushka.utils.ResourcesFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/products/create")
public class ProductsCreateServlet extends BaseServlet {

    private static final String CREATE_PRODUCT_FILE_PATH = "\\views\\products-create.html";

    @Inject
    protected ProductsCreateServlet(ProductService service, ResourcesFileReader reader) {
        super(service, reader);
    }

    @Override
    protected String getViewPath() {
        return CREATE_PRODUCT_FILE_PATH;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder typeOptions = new StringBuilder();

        for (Type t: Type.values()) {

            typeOptions.append("<option>" + t.toString() +"</option>");
        }

        String view = getContent().replace("{{{opt}}}", typeOptions.toString());

        PrintWriter writer = resp.getWriter();

        writer.write(view);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        String type = req.getParameter("type");

        ProductBindingModel model = new ProductBindingModel(name, desc, type);

        this.getService().save(model);

        resp.sendRedirect("/products/all");
    }
}
