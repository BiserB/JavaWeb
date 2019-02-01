package chushka.web;

import chushka.entities.Type;
import chushka.models.binding.ProductBindingModel;
import chushka.services.ProductService;
import chushka.utils.LocalFileReader;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/products/create")
public class ProductsCreateServlet extends BaseServlet {

    private static final String CREATE_PRODUCT_FILE_PATH = "D:\\JAVA\\SoftuniJavaWeb\\Exercise05ii\\src\\main\\resources\\views\\products-create.html";

    private static final String persistenceUnitName = "chushka";
    private EntityManager entityManager;

    @Inject
    protected ProductsCreateServlet(ProductService service, LocalFileReader reader) {
        super(service, reader);

        this.entityManager = Persistence
                .createEntityManagerFactory(persistenceUnitName)
                .createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = getReader().read(CREATE_PRODUCT_FILE_PATH);

        StringBuilder typeOptions = new StringBuilder();

        for (Type t: Type.values()) {

            typeOptions.append("<option>" + t.toString() +"</option>");
        }

        content = content.replace("{{{opt}}}", typeOptions.toString());

        PrintWriter writer = resp.getWriter();

        writer.write(content);
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
