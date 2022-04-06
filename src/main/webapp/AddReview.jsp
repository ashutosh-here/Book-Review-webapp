<%@page import="com.project.bookreview.entities.Publisher"%>
<%
  Publisher user11 = (Publisher) session.getAttribute("publisher");
  if(user11==null)
    response.sendRedirect("Login.jsp");
%>
<!DOCTYPE html>  
<html>
    <head>


  <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@700&display=swap" rel="stylesheet">


  <%@include file="components/common_css_js.jsp" %>
        <link rel="stylesheet" href="css/addreviewCSS.css">
        <script src="js/addreviewJS.js"></script>

      


        <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@500&display=swap" rel="stylesheet">
        <title>Add Review</title>
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
        
        
        
        <!-- FORM -->
        <h3><center>Fill the details</center></h3>
    <center>
        <div class="center">
            <form id="AddreviewForm" action="AddReviewServlet" method="post" enctype="multipart/form-data">
                <div>
                    <br>
                    <p>Author Name</p>
                    <input class="box"  id="Aname" type="text" name="Aname" placeholder="Author Name" required>
                    <br>
                    <p>Book Name</p>
                    <input class="box"  id="Bname" type="text" name="Bname" placeholder="Book Name" required>
                    <br>
                    <p>Book introduction</p>
                     <div class="form-group box mb-5">   <textarea id="Bintro"  name="Bintro" class="form-control" rows="3" placeholder="What this book is all about"></textarea></div>
                 <br>
                 <p>Your Favourite part</p>
                     <div class="form-group box mb-5">   <textarea id="Bfav"  name="Bfav" class="form-control" rows="3" placeholder="What was your favourite part of the book"></textarea></div>
                 <br>
                 <p>Book Audience</p>
                     <div class="form-group box mb-5">   <textarea id="Baud"  name="Baud" class="form-control" rows="3" placeholder="Who do u recommend this book or audience of this book"></textarea></div>
                 <br>
                 
                    <p>Upload Book image (Formats:png, jpeg)</p>

                    <div class="upload-btn-wrapper">
                        <button class="btn">Upload an image</button>
                        <!-- <input type="file" name="myfile"  required />  -->
                        <input type="file" name="bookpic" accept="image/*"  onchange="showMyImage(this)" required />


                    </div>
                    <br>
                 

                    <button type="button" class="subbutton" id ="btn" onclick="my()"

                            data-toggle="modal" data-target="#myModal">submit</button>



                </div>

            </form>
        </div>
    </center>


    <!--Modal screen-->

    <div id="myModal" class="modal fade" data-backdrop="static" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" id="cross" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title"> Preview</h3>
                </div>
                <div class="modal-body">
                    <img class="idimage" id="thumbnil" style="width:80%; margin-top:10px;" src="" alt="image" />

                    <!--<img id="thumbnil" style="width:80%; margin-top:10px;"  src="" alt="image"/>  -->
                    <table>
                        <tr>
                            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                        <tr>
                            <td><b>Author Name:-</b></td>
                            <td></td>
                            <td><span id="An"></span></td>
                        </tr>
                        <tr>
                            <td><b>Book name:-</b></td>
                            <td></td>
                            <td><span id="Bn"></span></td>
                        </tr>
                        <tr>
                            <td><b>Book intro:</b></td>
                            <td></td>
                            <td style="white-space: pre; word-wrap: break-word; overflow:visible!important"><span id="Bi"></span></td>
                        </tr>
                       <tr>
                            <td><b>Book fav:</b></td>
                            <td></td>
                            <td style="white-space: pre; word-wrap: break-word; overflow:visible!important"><span id="Bf"></span></td>
                        </tr>
                         <tr>
                            <td><b>Book Aud:</b></td>
                            <td></td>
                            <td style="white-space: pre; word-wrap: break-word; overflow:visible!important"><span id="Ba"></span></td>
                        </tr>
                    </table>
                
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="send()" class="btn-btn-default" data-dismiss="modal">Confirm 
                    </button>
                    <button type="button" class="btn-btn-edit" data-dismiss="modal"> Edit
                    </button>	
                </div>
            </div>
        </div>
    </div>
</div>





<%--<%@include  file="components/footer.jsp" %>--%>
</body>
</html>


