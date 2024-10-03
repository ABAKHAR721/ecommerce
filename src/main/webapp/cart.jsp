<%@ page import="Back.model.UserModel" %>

<%
    UserModel authUser = (UserModel) request.getSession().getAttribute("authUser");
    if(authUser !=null){
        request.setAttribute("authUser",authUser);
    }
%>
<html>
<head>
    <title>Cart!</title>
    <%@ include file="includes/head.jsp" %>
    <style type="text/css">

    .table tbody td{
    vertical-align: middle;
    }
    .btn-incre, .btn-decre{
    box-shadow: none;
    font-size: 25px;
    }
    </style>
</head>
<body>
<div></div>
<%@ include file="includes/navebare.jsp" %>

<div class="container">
    <div class="d-flex py-3">
        <h3>Total Price :300$</h3>
        <a class="mx-3 btn  btn-warning text-center" href="#">Check Out</a>
    </div>
    <table class="table table-light">
        <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Buy Now</th>
                <th scope="col">Cancel</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>jjj</td>
                <td>l</td>
                <td>l</td>
                <td>
                    <form action="" method="post" class="form-inline">
                        <input type="hidden" name="id" value="" class="form-input">
                        <div class="form-group d-flex justify-content-between">
                            <a class="btn btn-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>
                            <input type="text" name="quantity" class="form-control" value="" readonly>
                            <a class="btn btn-sm btn-decre" href=""><i class="fas fa-minus-square"></i></a>
                        </div>
                        <button type="submit" class="btn btn-primary btn-sm m-auto">Buy</button>
                    </form>
                </td>
                <td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
