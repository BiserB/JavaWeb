package metube.web.servlets;

import metube.services.TubeService;
import metube.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class UsersRegisterServlet extends BaseServlet {

    protected UsersRegisterServlet(TubeService service) {
        super(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/www/users-register.jsp").forward(req, resp);
    }
}
