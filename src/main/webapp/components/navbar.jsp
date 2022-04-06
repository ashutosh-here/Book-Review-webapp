
<%@page import="com.project.bookreview.entities.User"%>
<%
    User user11 = (User) session.getAttribute("current-user");


%>




<nav class="navbar navbar-expand-md navbar-dark bg-dark">

    <div class="container">
        <a class="navbar-brand" href="Home.jsp">Book Review</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
                </li>


            </ul>
            <!--    <form class="form-inline my-2 my-lg-0">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>-->


            <ul class="navbar-nav ml-auto">
                
               
                <%        if (user11 == null) {
                                  
                         %>
                    
                         
                         
                <li class="nav-item active m-2">
                    <a class="nav-link" href="Login.jsp">Login </a>
                </li>
                <li class="nav-item active m-2">
                    <a class="nav-link" href="register.jsp">Register </a>
                </li>
                         
                         
                         <%
                           } else {
                    
                     %>
                    
                         
                         
                <li class="nav-item active m-2">
                    <a class="nav-link" href="Home.jsp"><%=user11.getUserName() %> </a>
                </li>
                <li class="nav-item active m-2">
                    <a class="nav-link" href="LogoutServlet">Logout </a>
                </li>
                         
                         
                         <%
                    

                          }
                %>




            </ul>

        </div>
    </div>
</nav>