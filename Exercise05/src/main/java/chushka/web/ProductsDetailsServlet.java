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

@WebServlet("/products/details")
public class ProductsDetailsServlet extends BaseServlet {

    private static final String PRODUCTS_DETAILS_FILE_PATH = "\\views\\products-details.html";

    @Inject
    protected ProductsDetailsServlet(ProductService service, ResourcesFileReader reader) {
        super(service, reader);
    }

    @Override
    protected String getViewPath() {
        return PRODUCTS_DETAILS_FILE_PATH;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] queryData = req.getQueryString().split("=");

        String productId = queryData[1];

        ProductFullViewModel model = this.getService().getById(productId);

        String view = getContent().replace("{{{name}}}", model.getName())
                                .replace("{{{desc}}}", model.getDescription())
                                .replace("{{{type}}}", model.getType());

        PrintWriter writer = resp.getWriter();

        writer.write(view);
    }
}
