<%@ page import="Back.model.UserModel" %>
<%
    UserModel authUser = (UserModel) request.getSession().getAttribute("authUser");
    if (authUser != null) {
        response.sendRedirect("index.jsp");
        return; // Ensure to exit after redirect
    }
%>

<html>
<head>
    <title>Login!</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navebare.jsp" %>

<div class="container">
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <div class="alert alert-danger m-auto mt-3 text-center w-50" role="alert">
            <%= message %>
        </div>
    <% } %>

    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Login Form</div>
        <div class="card-body">
            <form action="Login" method="post">
                <div class="form-group m-3">
                    <label for="email">Email</label>
                    <input class="form-control" type="email" name="email" id="email" placeholder="Your email" required/>
                </div>

                <div class="form-group m-3">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" name="password" id="password" placeholder="* * * * * * * *" required/>
                </div>

                <div class="text-center w-80">
                    <button class="btn btn-success w-100 mt-3" type="submit">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
