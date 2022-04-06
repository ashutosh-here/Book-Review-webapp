/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.project.bookreview.dao.UserDao;
import com.project.bookreview.entities.User;
import com.project.bookreview.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashut
 */
@WebServlet(name = "GoogleAuthServlet", urlPatterns = {"/GoogleAuthServlet"})
public class GoogleAuthServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, GeneralSecurityException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
         String idTokenString=request.getParameter("idtoken").trim();
          //   out.println(idTokenString);
     String CLIENT_ID="914526410843-na9a6mfu5f4nakmakc4ag4hcrio7u1ad.apps.googleusercontent.com";
     GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
    // Specify the CLIENT_ID of the app that accesses the backend:
    .setAudience(Collections.singletonList(CLIENT_ID))
    // Or, if multiple clients access the backend:
    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
    .build();

// (Receive idTokenString by HTTPS POST)

GoogleIdToken idToken = verifier.verify(idTokenString);
if (idToken != null) {
  Payload payload = idToken.getPayload();

  // Print user identifier
  String userId = payload.getSubject();
  System.out.println("User ID: " + userId);
  System.out.println("DDDDONEEEE Google sign in");
  // Use or store profile information
  // ...
  // Get profile information from payload
  String email = payload.getEmail();
  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
  String name = (String) payload.get("name");
  String pictureUrl = (String) payload.get("picture");
  String locale = (String) payload.get("locale");
  String familyName = (String) payload.get("family_name");
  String givenName = (String) payload.get("given_name");
  
  
  
  
  
  
  
  
  
  //   now  check if the user already signed in earlier using this google acount 
  //   if  not then save the user to the DB as new user with given email
  // only checking user table becz only normal user will use this  google sign in
   UserDao userDao=  new UserDao(FactoryProvider.getFactory());
   //   System.out.println("ccccccccccc");
     if(userDao.ifUserExists(email)){
            System.out.println("User Already exists");
            
             // saving the current user in the seesion
                     HttpSession ss=request.getSession();
                     User user=userDao.getUserByEmail(email);
                     ss.setAttribute("current-user", user);
            // redirect to rating page
                  response.sendRedirect("Home.jsp");
     }
     else{
            System.out.println("User Already not exists");   
            User user=new User(name,email,"default","default","default");
            
            int uid=userDao.saveUser(user);
            if(uid<0)
                System.out.println("Cant save the google signed in user");  //redirect to error page
            else{
                 System.out.println("Saved the google signed in user userID in Db:-"+uid);
              
                 
                 // saving the current user in the seesion
                     HttpSession ss=request.getSession();
                     ss.setAttribute("current-user", user);


       //redirect to rating page
                 response.sendRedirect("Home.jsp");
                 
            } 
            
     }
   
  
  
  
  
  
  
  
  
  
  
  
  

} else {
  System.out.println("Invalid ID token."); //redirect to error page
}

            
            
            
            
            
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(GoogleAuthServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(GoogleAuthServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
