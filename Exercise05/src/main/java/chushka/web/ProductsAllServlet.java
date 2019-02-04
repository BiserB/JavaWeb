package chushka.web;

import chushka.models.view.ProductFullViewModel;
import chushka.services.ProductService;
import chushka.utils.ResourcesFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products/all")
public class ProductsAllServlet extends BaseServlet {

    private static final String PRODUCTS_ALL_FILE_PATH = "\\views\\products-all.html";

    @Inject
    protected ProductsAllServlet(ProductService service, ResourcesFileReader reader) {
        super(service, reader);
    }

    @Override
    protected String getViewPath() {
        return PRODUCTS_ALL_FILE_PATH;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder result = new StringBuilder();

        List<ProductFullViewModel> models = this.getService().getAll();

        for (ProductFullViewModel p: models) {

            result.append("<li><a href=/products/details?id=" + p.getId() + ">"  + p.getName() +"</a></li>");
        }

        String view = getContent().replace("{{{p}}}", result.toString());

        PrintWriter writer = resp.getWriter();

        writer.write(view);
    }
}
