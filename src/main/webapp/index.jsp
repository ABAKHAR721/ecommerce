<%@ page import="Back.model.UserModel" %>
<%@ page import="Back.dao.ProductDao" %>
<%@ page import="Back.model.Product" %>
<%@ page import="Back.connection.DbCon" %>
<%@ page import="java.util.List" %>

<%
    ProductDao pd = new ProductDao(DbCon.getConnection());
    List<Product> products = pd.getAllProduct();

    UserModel authUser = (UserModel) request.getSession().getAttribute("authUser");
    if (authUser != null) {
        request.setAttribute("authUser", authUser);
    }
%>

<html>
<head>
    <title>Home!</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
    <%@ include file="includes/navebare.jsp" %>

    <div class="container">
     <%
            String message = (String) request.getAttribute("ItemExistMessage");
            if (message != null) {
        %>
            <div class="alert alert-danger m-auto mt-3 text-center w-50" role="alert">
                <%= message %>
                <a class="btn btn-sm" href='cart.jsp'>Go to your Cart</a>
            </div>
        <% } %>
        <h2 class="card-header my-5">All Products</h2>
        <div class="row">
            <% if (!products.isEmpty()) {
                for (Product p : products) { %>
                    <div class="col-md-3 mb-4">
                        <div class="card w-100">
                            <img class="card-img-top" src="images/products/<%= p.getImage() %>" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title"><%= p.getName() %></h5>
                                <h5 class="price">Price: <%= p.getPrice() %>$</h5>
                                <h5 class="category">Category: <%= p.getCategory() %></h5>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark mx-1">Add to Cart</a>
                                    <a href="#" class="btn btn-success mx-1">Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
            <% }
            } %>
        </div>
    </div>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
