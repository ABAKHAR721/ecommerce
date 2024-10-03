package Back.servlet;

import Back.connection.DbCon;
import Back.dao.UserDao;
import Back.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            UserDao udao = new UserDao(DbCon.getConnection());
            UserModel user = udao.userlogin(email, password);
            if (user != null) {
                req.getSession().setAttribute("authUser", user);
                resp.sendRedirect("index.jsp");
            } else {
                req.setAttribute("message", "Email or Password  Are Not Correct ,Try Again !");
                req.getRequestDispatcher("login.jsp").forward(req, resp); // Redirect to the login page with message
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            req.setAttribute("message", "An error occurred. Please try again later.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
