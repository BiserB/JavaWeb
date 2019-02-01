package fdmc.web;

import fdmc.repositories.CatRepository;
import fdmc.common.LocalFileReader;
import fdmc.entities.Cat;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {

    private final LocalFileReader reader;

    @Inject
    public CatsCreateServlet(LocalFileReader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filePath = "D:\\JAVA\\SoftuniJavaWeb\\Exercise04\\src\\main\\resources\\create-cat.html";

        String content = reader.read(filePath);

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("cat_name");
        String breed = req.getParameter("cat_breed");
        String color = req.getParameter("cat_color");
        int age = Integer.parseInt(req.getParameter("cat_age"));

        Cat newCat = new Cat(name, breed, color, age);

        CatRepository.catList.add(newCat);

        resp.sendRedirect("/cats/profile?catName=" + name);
    }
}
