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

@WebServlet("/cats/all")
public class CatsAllServlet extends HttpServlet {


    private final LocalFileReader reader;

    @Inject
    public CatsAllServlet(LocalFileReader reader) {
        this.reader = reader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filePath = "D:\\JAVA\\SoftuniJavaWeb\\Exercise04\\src\\main\\resources\\all-cats.html";

        String content = reader.read(filePath);

        String allCats = "There are no cats. <a href=\"/cats/create\">Create some!</a>";

        if (CatRepository.catList.size() != 0)
        {
            StringBuilder sb = new StringBuilder();

            sb.append("<table><thead>");

            sb.append("<tr><th style=\"width:50px\"> No </th><th style=\"width:500px\"> Cat Name </th><th style=\"width:50px\"> Age </th></tr></thead><tbody>");

            int num = 0;

            for (Cat cat:CatRepository.catList) {

                String nameLink = "<a class=\"large\" href = /cats/profile?catName=" + cat.getName() + ">" + cat.getName() + "</a>";

                sb.append("<tr><th> " +  ++num +" </th><th> " + nameLink +" </th><th> "+ cat.getAge() +" </th></tr>");
            }

            sb.append("</tbody></table>");

            allCats = sb.toString();
        }

        content = String.format(content, allCats);

        PrintWriter writer = resp.getWriter();

        writer.write(content);
    }


}
