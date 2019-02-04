package chushka.web;

import chushka.models.view.ProductLinkViewModel;
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
import java.util.stream.Collectors;


@WebServlet("/")
public class IndexServlet extends BaseServlet {

    private static final String INDEX_FILE_PATH = "\\views\\index.html";
    private static int counter;

    @Inject
    public IndexServlet(ProductService service, ResourcesFileReader reader) {
        super(service,reader);
    }

    @Override
    protected String getViewPath() {
        return INDEX_FILE_PATH;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ProductLinkViewModel> models = getService().getProductLinkViewModels();

        String names = models
                .stream()
                .map(m -> new String("<li><a href=\"/products/details?id=" + m.getId() + "\"> " + m.getName() + "</a></li>"))
                .collect(Collectors.joining());

        String view = getContent().replace("{{{products}}}", names);

        PrintWriter writer = resp.getWriter();

        writer.write(view);
    }
}
