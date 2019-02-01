package fdmc.web;

import fdmc.common.LocalFileReader;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final LocalFileReader reader;

    @Inject
    public IndexServlet(LocalFileReader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filePath = "D:\\JAVA\\SoftuniJavaWeb\\Exercise04\\src\\main\\resources\\index.html";

        String content = reader.read(filePath);

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }
}
