/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.servlets;

import com.project.bookreview.dao.AdminDao;
import com.project.bookreview.dao.PublisherDao;
import com.project.bookreview.dao.UserDao;
import com.project.bookreview.entities.Admin;
import com.project.bookreview.entities.Publisher;
import com.project.bookreview.entities.User;
import com.project.bookreview.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashut
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            String email=request.getParameter("email").trim();   String password=request.getParameter("password").trim();
            
               System.out.println("here----"+email+" --"+password);
               
               
               
               // valiadte user from DB
                  UserDao userDao=  new UserDao(FactoryProvider.getFactory());
                  User user=userDao.getUserByEmailAndPassword(email, password);
                  
                  boolean isAdmin=new AdminDao(FactoryProvider.getFactory()).isAdmin(email);
                  boolean isPub=new PublisherDao(FactoryProvider.getFactory()).isPublisher(email);
                  
                        HttpSession ss=request.getSession();
                  
                  // two cases 
                  //1. credentials are wrong 
                  //2. he is admin or he is publisher
                  if(user==null){
                      
                          // if its admin 
                      if(isAdmin){
                         //verify admin credentials 
                    Admin admin=new AdminDao(FactoryProvider.getFactory()).getAdminByEmailAndPassword(email, password);
                          if(admin!=null){
                                  System.out.println("Adminnnnn user");
                            // redirect to admin page
                             ss.setAttribute("admin", admin);
                                 ss.setAttribute("isAdmin", "Y");
                                response.sendRedirect("admin.jsp");
                          }
                      }    
                      else if (isPub){
                          
                           //verify admin credentials 
                     Publisher pub=new PublisherDao(FactoryProvider.getFactory()).getPublisherByEmailAndPassword(email, password);
                          if(pub!=null){
                              
                                  System.out.println("publisherrrr");
                                  //redirect to publisher page
                                  ss.setAttribute("publisher", pub);
                              response.sendRedirect("Publisher.jsp");
                          }
                  
                      }
                      else{ 
                      
                      //show message wrong credentials
                      System.out.println("null user");
                      ss.setAttribute("message", "Wrong credentials");
                      }
                  }
                  
                  // else he is normal user
                  else{
                       // saving the current user in the seesion
               
                     ss.setAttribute("current-user", user);
                 
                          //redirect to rating page
                          System.out.println("Normal User");
                          
                  response.sendRedirect("Home.jsp");
                      
                      
                      
                      
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
        processRequest(request, response);
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
        processRequest(request, response);
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
