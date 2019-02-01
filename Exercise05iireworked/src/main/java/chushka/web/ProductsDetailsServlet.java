
package chushka.web;

import chushka.models.view.ProductFullViewModel;
import chushka.services.ProductService;
import chushka.utils.LocalFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/products/details")
public class ProductsDetailsServlet extends BaseServlet {

    private static final String PRODUCTS_DETAILS_FILE_PATH = "D:\\JAVA\\SoftuniJavaWeb\\Exercise05ii\\src\\main\\resources\\views\\products-details.html";

    @Inject
    protected ProductsDetailsServlet(ProductService service, LocalFileReader reader) {
        super(service, reader);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = getReader().read(PRODUCTS_DETAILS_FILE_PATH);

        String[] queryData = req.getQueryString().split("=");

        String productName = queryData[1];

        ProductFullViewModel model = this.getService().getByName(productName);

        content = content.replace("{{{model}}}", model.getName());

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }
}
