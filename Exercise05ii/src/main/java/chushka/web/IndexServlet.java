package chushka.web;

import chushka.models.view.ProductLinkViewModel;
import chushka.services.ProductService;
import chushka.utils.LocalFileReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class IndexServlet extends BaseServlet {

    //private static final String INDEX_FILE_PATH = "D:\\JAVA\\SoftuniJavaWeb\\Exercise05ii\\src\\main\\resources\\views\\index.html";
    private static final String INDEX_FILE_PATH = "../index.html";

    @Inject
    public IndexServlet(ProductService service, LocalFileReader reader) {
        super(service,reader);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = getReader().read(INDEX_FILE_PATH);

        List<ProductLinkViewModel> models = getService().getProductLinkViewModels();

        String names = models
                .stream()
                .map(m -> new String("<li><a href=\"/products/details?id=" + m.getId() + "\"> " + m.getName() + "</a></li>"))
                .collect(Collectors.joining());

        content = content.replace("{{{products}}}", names);

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }
}
