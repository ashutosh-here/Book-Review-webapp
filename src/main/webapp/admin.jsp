
<!--       add publisher ,view publisher,view books, view users   -->


<%@page import="java.util.Map"%>
<%@page import="com.project.bookreview.helper.userPublisherReviewCount"%>
<%@page import="com.project.bookreview.helper.FactoryProvider"%>
<%@page import="com.project.bookreview.dao.AdminDao"%>


<%@ page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="SHORTCUT ICON" href="favicon.ico" type="image/x-icon" />


        <%--<%@include file="components/common_css_js.jsp" %>--%> 

        <title>Admin Dashboard</title>
        <%@include file="components/common_css_js.jsp" %>



        <style>
            .prd{background-color: #5e35b1;}
            .cat{ background-color: #ff7043;}
            .warning {background-color: #f0ad4e}
            .danger {background-color: #d9534f}
            .success {background-color: #5cb85c}
            .inf {background-color: #5bc0de}

            .statis {
                color: #EEE;
                margin-top: 15px;
            }
            .statis .box {
                position: relative;
                padding: 15px;
                overflow: hidden;
                border-radius: 3px;
                margin-bottom: 25px;
            }
            .statis .box h3:after {
                content: "";
                height: 2px;
                width: 70%;
                margin: auto;
                background-color: rgba(255, 255, 255, 0.12);
                display: block;
                margin-top: 10px;
            }
            .statis .box i {
                position: absolute;
                height: 70px;
                width: 70px;
                font-size: 22px;
                padding: 15px;
                top: -25px;
                left: -25px;
                background-color: rgba(255, 255, 255, 0.15);
                line-height: 60px;
                text-align: right;
                border-radius: 50%;
            }

            * {
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-family: 'Droid Sans', sans-serif;
                outline: none;
            }
            ::-webkit-scrollbar {
                background: transparent;
                width: 5px;
                height: 5px;
            }
            ::-webkit-scrollbar-thumb {
                background-color: #888;
            }
            ::-webkit-scrollbar-thumb:hover {
                background-color: rgba(0, 0, 0, 0.3);
            }
            body {background-color: #2a2b3d}
        </style>




    </head>
    <body style="background-color: #2a2b3d!important;"> 









        <!--admin validations-->
        <c:set var="userSS" scope="session" value="${sessionScope['admin']}"   />
        <!-- <%--       <c:out value="${userSS}"/><br>
                <c:out value="${userSS.userType}"/><br>     --%>-->

        <c:choose>
            <c:when test="${userSS==null}">

                <c:set var="message" scope="session" value="You are not logged in !! Login first"   />

                <c:redirect url="Login.jsp"/>

            </c:when>

            <c:otherwise>       


                <c:set var="String" value="${sessionScope['isAdmin']}"/> 

                <c:if test="${!(fn:contains(String, 'Y'))}">



                    <c:set var="message" scope="session" value="You are not Admin !! Acess Denied !!"   />

                    <c:redirect url="Login.jsp"/>

                </c:if>
            </c:otherwise>
        </c:choose> 
        <!--admin validations ends -->



        <!--to get dynamic user and product count-->
        <%

            Map<String, Long> map = userPublisherReviewCount.getCounts();


        %>

        <!--cards-->

        <div id="admin" class="container"  style="margin-top: 120px!important;">

            <div class="container-fluid mt-3"> 
                <%@include file="components/Message.jsp" %>   
            </div> 





            <!--add publisher-->

            <div class="row mt-3">

                <div class="statis text-center  col-md-3">


                    <div style="cursor: pointer" class="box prd"  data-toggle="modal" data-target="#add-product-modal"  >
                        <i class="fa fa-shopping-cart"></i>
                        <img class="img-fluid"  style="max-width: 85px" src="img/Box-Add-198.png"/>

                        <h3>Add new publisher</h3>
                        <p class="lead">click here to add new publisher</p>
                    </div>





                </div>

                <div class="statis col-md-3 text-center">


                    <div class="box danger">
                         <a href="AllUsers.jsp"  class="stretched-link" ></a>
                        <i class="fa fa-user-o"></i>
                        <h3><%=map.get("userCount")%></h3>
                        <p class="lead">User registered</p>
                    </div>      


                </div>
                <div class="statis col-md-3 text-center">


                    <div class="box danger">
                             <a href="AllPublishers.jsp"  class="stretched-link" ></a>
                        <i class="fa fa-user-o"></i>
                        <h3><%=map.get("publisherCount")%></h3>
                        <p class="lead">Publishers registered</p>
                    </div>      


                </div>   <div class="statis col-md-3 text-center">


                    <div class="box danger">
                             <a href="AllReviews.jsp"  class="stretched-link" ></a>
                        <i class="fa fa-user-o"></i>
                        <h3><%=map.get("reviewCount")%></h3>
                        <p class="lead">Book Reviews</p>
                    </div>      


                </div>

            </div>



        </div>


        <!--add publisher modal-->



        <!-- Modal -->
        <div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Publisher details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="AddPublisherServlet" method="post" >



                            <div class="form-group">
                                <input type="text" class="form-control" name="Fname" required="true" placeholder="Enter first name"/>
                            </div> 
                            <div class="form-group">
                                <input type="text" class="form-control" name="Lname" required="true" placeholder="Enter last name"/>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male">
                                <label class="form-check-label" for="inlineRadio1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="Famale">
                                <label class="form-check-label" for="inlineRadio2">Female</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio3" value="Prefer not to say" >
                                <label class="form-check-label" for="inlineRadio3">Prefer not to say</label>
                            </div>
                            
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" required="true" placeholder="Enter email"/>
                            </div> 
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" required="true" placeholder="Enter password"/>
                            </div>

                            <div class="form-group">
                                <input type="tel" pattern="^\d{10}$" class="form-control" name="contact" required="true" placeholder="Enter 10 digit contact number"/>
                            </div> 


                            <div class="form-group">
                                <textarea style="height:152px;" class="form-control" name="address" required="true" placeholder="Enter address"></textarea>
                            </div>


                            

                            <div class="container text-center">
                                <button type="submit" class="btn btn-outline-success">Add Publisher</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>




                        </form>
                    </div>

                </div>
            </div>
        </div>



        <!--end add publisher modal-->








<!--     <div id="About" class="container-fluid" style=" position: relative;margin-bottom: 0px!important;padding:0px!important">
                <%--<%@include file="components/footer.jsp" %>--%> 

            </div>   -->

    </body>
</html>
