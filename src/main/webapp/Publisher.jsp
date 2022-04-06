<%@page import="com.project.bookreview.dao.ReviewDao"%>
<%@page import="com.project.bookreview.entities.Review"%>
<%@page import="java.util.List"%>
<%@page import="com.project.bookreview.helper.FactoryProvider"%>
<%@page import="com.project.bookreview.entities.Publisher"%>
<%
  Publisher user11 = (Publisher) session.getAttribute("publisher");
  if(user11==null)
    response.sendRedirect("Login.jsp");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= user11.getPublisherFname()    %></title>
        
        
        <%@include file="components/common_css_js.jsp" %> 

        <link href="css/publisherCSS.css" rel="stylesheet" type="text/css"/>

      
        
        
    </head>
    <body>
      
        
        
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
                    <a class="nav-link" href="Publisher.jsp"><%=user11.getPublisherFname() %> </a>
                </li>
                  <li class="nav-item active m-2">
                    <a class="nav-link" href="AddReview.jsp">Add new Review </a>
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
        
        
        
        
        
        
      <div class="container">

          
          
          
          
          
          
<!-- Card deck -->
<div class="card-deck row">

    
    <%
        
List<Review> rlist=new ReviewDao(FactoryProvider.getFactory()).getAllReviewsById(user11.getPublisherId())   ;
    
    
for(Review rev: rlist){
    %>
    
    
  <div class="col-xs-12 col-sm-6 col-md-4">
  <!-- Card -->
  <div class="card">

    <!--Card image-->
    <div class="view overlay">
        <img class="card-img-top" src="img/<%=rev.getBookImage() %>" alt="Card image cap">
      <a href="#!">
        <div class="mask rgba-white-slight"></div>
      </a>
    </div>

    <!--Card content-->
    <div class="card-body">

      <!--Title-->
      <h4 class="card-title"><%=rev.getBookName() %></h4>
      <!--Text-->
      <p class="card-text"><%=rev.getBookIntro() %></p>
      <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
      <a  href="PublisherReview.jsp?rid=<%=rev.getReviewId()%>" type="button" class="btn btn-light-blue btn-md">Read more</a>

    </div>

  </div>
  <!-- Card -->
  </div>

    
    <%
        }
       if (rlist.size() == 0) {
                                out.println("<h2>No Reviews yet </h2>");
                            }
    %>
  
</div>
<!-- Card deck -->
  
</div>
            
<!--            
               <div id="About" class="container-fluid" style=" position: relative;margin: 0px!important;padding:0px!important">
                <%--<%@include file="components/footer.jsp" %>--%> 
                       </div>-->
            
            
            
    </body>
</html>
