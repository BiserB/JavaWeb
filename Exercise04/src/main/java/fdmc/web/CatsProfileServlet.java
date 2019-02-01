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

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {


    private final LocalFileReader reader;

    @Inject
    public CatsProfileServlet(LocalFileReader reader) {
        this.reader = reader;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String filePath = "D:\\JAVA\\SoftuniJavaWeb\\Exercise04\\src\\main\\resources\\cat-profile.html";

        String content = reader.read(filePath);

        String catName = req.getParameter("catName");

        if (catName == null){

            resp.sendRedirect("/");
            return;
        }

        Cat cat = null;

        for (Cat c: CatRepository.catList ) {
            if (c.getName().equalsIgnoreCase(catName)) {
                cat = c;
                break;
            }
        }

        String profile;

        if (cat == null) {

            profile = "<h1>Cat with name " + catName + " was not found!</h1><hr/>";
        }
        else{
            profile = "<h1>Cat - " + cat.getName() + "</h1>" +
                    "<hr/>" +
                    "<p class=\"large\">" +
                    "<b>Breed:</b> " + cat.getBreed() + " <br/>" +
                    "<b>Color:</b> " + cat.getColor() + " <br/>" +
                    "<b>Age: </b> " + cat.getAge() + " <br/></p>";
        }

        content = String.format(content, profile);

        writer.write(content);
    }


}

