<%--
delete button to delete review by review id in reviewDao

show feedback and rating properly mapped 

--%>

<%@page import="com.project.bookreview.entities.Feedback"%>
<%@page import="com.project.bookreview.entities.Rating"%>
<%@page import="com.project.bookreview.entities.Publisher"%>
<%@page import="com.project.bookreview.dao.ReviewDao"%>
<%@page import="com.project.bookreview.helper.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.project.bookreview.entities.Review"%>
<%@page import="com.project.bookreview.entities.Review"%>
<%
 Publisher user11 = (Publisher) session.getAttribute("publisher");
    int rid = Integer.parseInt(request.getParameter("rid"));

    ReviewDao rDao=new ReviewDao(FactoryProvider.getFactory());
      Review rev=rDao.getrReviewById(rid);

List<Rating> ratingList=rDao.getRatingOnReviewById(rid);
List<Feedback> feedList=rDao.getFeedbacksOnReviewById(rid);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=rev.getBookName() %> -<%= user11.getPublisherFname()    %></title>
        <%@include file="components/common_css_js.jsp" %> 
   
        <link href="css/reviewCSS.css" rel="stylesheet" type="text/css"/>
        <script src="js/reviewJS.js" type="text/javascript"></script>
        <link rel="SHORTCUT ICON" href="favicon.ico" type="image/x-icon" />





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
                    
                         
                         
                <li class="nav-item active">
                    <a class="nav-link" href="Login.jsp">Login </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Register </a>
                </li>
                         
                         
                         <%
                           } else {
                    
                     %>
                    
                            <li class="nav-item active m-2">
                    <a class="nav-link" href="Home.jsp"><%=user11.getPublisherFname() %> </a>
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



        <div  style="margin-top: 135px; margin-bottom: 50px; " class="tm-section single-product-details-area ptb-80 bg-white">
            <div class="container">
                <!-- Start single product details inner -->
                <div class="single-pro-details-inner">
                    <div class="row">

                       
                        <div class="col-md-6">

                             <div class="single-product-description">
                                 <h3 class="tm-single-product-title"><%=rev.getBookName()%> by <%=rev.getAuthorName() %></h3>
                            
                            
                                 <p class="product-details-paragraph"><%=rev.getBookIntro() %></p>
                               <h3 class="tm-single-product-title">Fav part</h3>
                                 <p class="product-details-paragraph"><%=rev.getBookFavPart() %></p>
                                      <h3 class="tm-single-product-title">Audience</h3>
                                 <p class="product-details-paragraph"><%=rev.getBookAudience() %></p>
                                 
                                 
                           <% 
                               float sum=0;
                               float avg=0;
                               
                                     for(Rating rating:ratingList){ 
                                      sum=sum+rating.getUserRating();
                                     }
                                if (ratingList.size() != 0)     
                                     avg=sum/ratingList.size() ;
                           %>              
                               
                           <h2>Average rating: </h2>  
                                    <h3 class="mb-5"><%=avg   %></h3>
                            <%      if (ratingList.size() == 0) {
                                out.println("<h2>No Ratings yet </h2>");
                            }      %>  
                            
                            <h1>Feedbacks</h1>
                            <%   for(Feedback feed:feedList){      %>              
                                 
                                 
                               <h3><%=feed.getUserFeedback()   %></h3>

                            <%      } if (feedList.size() == 0) {
                                out.println("<h2>No Feedbacks yet </h2>");
                            }      %>  
                            
                            
                            
                        </div>
                            
                            
                        </div>    
                                
                                
                        <div class="col-md-4">
                            <div class='img'>
                                <img  class="m-2  img-fluid" style=" max-height: 320px!important; width: 100%!important;" src="img/<%= rev.getBookImage()  %>" alt="image">

                                <!--<img src='https://tctechcrunch2011.files.wordpress.com/2014/11/solo2-wireless-red-quarter.jpg?w=738'>-->
                            </div>
                        </div>       





                    </div>
                </div>
                <!-- End single product details inner -->   
                
                
               


 
                
                
                
            </div>
        </div>









 <div id="About" class="container-fluid" style=" position: relative;margin-top: 250px!important;padding:0px!important">
             <%--<%@include file="footer.jsp" %>--%> 
            
        </div>
                                
                    <div id="About" class="container-fluid" style=" position: relative;margin: 0px!important;padding:0px!important">
                <%@include file="components/footer.jsp" %> 

            </div>                        
    </body>
</html>
