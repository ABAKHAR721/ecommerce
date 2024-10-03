package Back.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;  // Corrected serialVersionUID spelling

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()){
            if (req.getSession().getAttribute("authUser") !=null){
                req.getSession().removeAttribute("authUser");
                resp.sendRedirect("login.jsp");
            }else{
                resp.sendRedirect("login.jsp");
            }
        }
    }

}
