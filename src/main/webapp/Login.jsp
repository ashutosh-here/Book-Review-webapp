<%-- 
    Document   : Login
    Created on : 28 May, 2021, 3:15:14 PM
    Author     : ashut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="google-signin-client_id" content="914526410843-na9a6mfu5f4nakmakc4ag4hcrio7u1ad.apps.googleusercontent.com">

        <title>Login Page</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>

  <%@include file="components/common_css_js.jsp" %>   
    <link href="css/loginCSS.css" rel="stylesheet" type="text/css"/>
        <script src="js/loginJS.js" type="text/javascript"></script>
    </head>
    <body>
      <div id="container">
          
          
           <div class="container-fluid mt-3"> 
                <%@include file="components/Message.jsp" %>   
            </div> 
          
                  <!--if user is already signed in redirect it to logout page->
                  
        <c:set var="userSS" scope="session" value="${sessionScope['current-user']}"   />
        <!-- <%--       <c:out value="${userSS}"/><br>
                <c:out value="${userSS.userType}"/><br>     --%>-->

        <c:choose>
            <c:when test="${userSS!=null}">

                <c:set var="message" scope="session" value="You are already logged in !! First Logout from the current session"   />

                <c:redirect url="Logout.jsp"/>

            </c:when>

     
        </c:choose> 
        <!--login validations ends -->
            
            
          
  <div id="left">
    <h1 id="welcome">Welcome</h1>
    <p id="lorem">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br>
      Vivamus sodales eros non arcu pellentesque convallis.<br>
      Nunc dignissim lectus in malesuada porta.<br>
      Proin ac erat sed urna congue suscipit.<br>
      Morbi aliquet eget nisl id ornare.
    </p>
  </div>
  <div id="right">
    <h1 id="login">LogIn</h1><br>
    
    <form action="LoginServlet">
    <input  name="email" type="email" id="email" class="client-info">
    <label for="email">Email</label>
    <input name="password" type="password" id="password" class="client-info">
    <label for="password">Password</label>
    <input type="submit" id="submit" class="client-info" value="Submit">
  
    </form>
      <button class="social" id="facebook">connect with facebook</button>
    <button class="social g-signin2"  data-onsuccess="onSignIn"></button>
     <!--<h1><div class="g-signin2" data-onsuccess="onSignIn"></div>-->
            
            <!--<a href="#" onclick="signOut();">Sign out</a>-->
            
            
            

  </div>
</div>

    </body>
</html>
