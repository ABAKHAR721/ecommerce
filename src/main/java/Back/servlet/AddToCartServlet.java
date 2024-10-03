package Back.servlet;


import Back.model.CartModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  String message="";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try(PrintWriter out = resp.getWriter()){
            ArrayList<CartModel> CartList = new ArrayList<>();
            int id = Integer.parseInt(req.getParameter("id"));
            CartModel cm = new CartModel();
            cm.setQuantity(1);
            cm.setId(id);

            HttpSession session = req.getSession();
            ArrayList<CartModel> cart_list = (ArrayList<CartModel>) session.getAttribute("cart-list");
            if (cart_list ==null){
                CartList.add(cm);
                session.setAttribute("cart-list",CartList);
                resp.sendRedirect("index.jsp");
            }else{
                CartList = cart_list;
                boolean exist =false;
                for (CartModel c:cart_list){
                    if (c.getId()==id){
                        exist=true;
                        message="Item already exist in Cart.";
                        req.setAttribute("ItemExistMessage",message);
                        req.getRequestDispatcher("index.jsp").forward(req, resp);

                    }
                }
                if (!exist) {
                    CartList.add(cm);
                    resp.sendRedirect("index.jsp");
                }
            }


        }
    }
}