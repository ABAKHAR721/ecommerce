<div class="container">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <!-- Brand and toggler on the left -->
            <a class="navbar-brand" href="index.jsp">E-commerce Shopping Cart</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Links on the right -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="cart.jsp">Cart</a>
                    </li>
                    <% if(authUser != null){ %>
                            <li class="nav-item">
                               <a class="nav-link" href="orders.jsp">Orders</a>
                            </li>
                            <li class="nav-item">
                               <a class="nav-link" href="Logout">Logout</a>
                            </li>
                    <% }else{ %>
                        <li class="nav-item">
                           <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                   <% } %>
                </ul>
            </div>
        </div>
    </nav>
</div>
