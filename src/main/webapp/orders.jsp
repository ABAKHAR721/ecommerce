<%@ page import="Back.model.UserModel" %>

<%
    UserModel authUser = (UserModel) request.getSession().getAttribute("authUser");
    if(authUser !=null){
        request.setAttribute("authUser",authUser);
    }else{
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <title>Your orders !</title>
    <%@ include file="includes/head.jsp"   %>
</head>
<body>
<%@ include file="includes/navebare.jsp"   %>
    <div class="container">
        <h1>Orders Page!</h1>
    </div>

<%@ include file="includes/footer.jsp"   %>
</body>
</html>
