

<%@page import="com.project.bookreview.dao.ReviewDao"%>
<%@page import="com.project.bookreview.helper.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.project.bookreview.entities.Review"%>
<%@page import="com.project.bookreview.entities.Review"%>
<%

    int rid = Integer.parseInt(request.getParameter("rid"));

      Review rev=new ReviewDao(FactoryProvider.getFactory()).getrReviewById(rid);


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=rev.getBookName() %></title>
        <%@include file="components/common_css_js.jsp" %> 
   
        <link href="css/reviewCSS.css" rel="stylesheet" type="text/css"/>
        <script src="js/reviewJS.js" type="text/javascript"></script>
        <link rel="SHORTCUT ICON" href="favicon.ico" type="image/x-icon" />





    </head>
    <body>
            <%@include  file="components/navbar.jsp" %>



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
                
                
               
<%-- 
 if user already given rating to this review id dont show this page

make method in userDao (Select * from Rting & Feedback where reviewid=revid(login) and userid=uid(login)

--%>

<div class='rating-box'>
<form class='rating-form'>
  <fieldset>
<!--     <span class="star-cb-group">
      <input type="radio" id="rating-5" name="rating" value="5" /><label for="rating-5">5</label>
      <input type="radio" id="rating-4" name="rating" value="4" /><label for="rating-4">4</label>
      <input type="radio" id="rating-3" name="rating" value="3" /><label for="rating-3">3</label>
      <input type="radio" id="rating-2" name="rating" value="2" /><label for="rating-2">2</label>
      <input type="radio" id="rating-1" name="rating" value="1" /><label for="rating-1">1</label>
      <input type="radio" id="rating-0" name="rating" value="0" checked="checked" class="star-cb-clear" /><label for="rating-0">0</label>
    </span> -->
    
    <div id="full-stars-example-two">
    <div class="rating-group">
        <input disabled checked class="rating__input rating__input--none" name="rating" id="rating3-none" value="0" type="radio">
        <label aria-label="1 star" class="rating__label" for="rating3-1"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        <input class="rating__input" name="rating" id="rating3-1" value="1" type="radio">
        <label aria-label="2 stars" class="rating__label" for="rating3-2"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        <input class="rating__input" name="rating" id="rating3-2" value="2" type="radio">
        <label aria-label="3 stars" class="rating__label" for="rating3-3"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        <input class="rating__input" name="rating" id="rating3-3" value="3" type="radio">
        <label aria-label="4 stars" class="rating__label" for="rating3-4"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        <input class="rating__input" name="rating" id="rating3-4" value="4" type="radio">
        <label aria-label="5 stars" class="rating__label" for="rating3-5"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        <input class="rating__input" name="rating" id="rating3-5" value="5" type="radio">
    </div>
  <p class="desc" style="font-family: sans-serif; font-size:0.9rem">Give stars<br/>
    Minimum one star</p>
</div>
  </fieldset>

  <fieldset>
    <textarea name='feedBack' id='review' maxlength='100' placeholder='Write your review here (Required)' required></textarea>
    </fieldset>
    <fieldset>
        <input type="hidden" id="revId" name="revId" value=<%=rid%>>
    </fieldset>
  <span style="display:none;" class='error'>error Msg</span>
  <fieldset>
    <input type='button' value='Submit' id='submit'>
  </fieldset>
  
</form>
  <p class='rating-success'>Thank you for your review</p>
</div>
 
                
                
                
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
