<%-- 
    Document   : AddReview
    Created on : 31 May, 2021, 10:59:10 AM
    Author     : ashut
--%>

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





</body>
</html>


