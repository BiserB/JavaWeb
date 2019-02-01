package chushka.web;

import chushka.services.ProductService;
import chushka.utils.HttpFileReader;
import chushka.utils.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final ProductService service;
    private final HttpFileReader reader;
    private final ModelMapper mapper;

    @Inject
    public IndexServlet(ProductService service, HttpFileReader reader, ModelMapper mapper) {
        this.service = service;
        this.reader = reader;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filePath = "D:\\JAVA\\SoftuniJavaWeb\\Exercise05\\src\\main\\resources\\index.html";

        String content = reader.read(filePath);

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }
}
