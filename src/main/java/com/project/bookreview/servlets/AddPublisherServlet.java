/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.servlets;

import com.project.bookreview.dao.PublisherDao;
import com.project.bookreview.entities.Publisher;
import com.project.bookreview.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashut
 */
public class AddPublisherServlet extends HttpServlet {

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
           
   /*            // printing values for testing  
             System.out.println("******started*********");
            Enumeration<String> names = request.getParameterNames();

            while (names.hasMoreElements()) {
                String nn = names.nextElement();
                System.out.println(nn);
                System.out.println("*******values********");
                System.out.println(request.getParameter(nn));
            }
    
            System.out.println("*****ended************");        

*/

            String fname=request.getParameter("Fname");
              String lname=request.getParameter("Lname");
                String gender=request.getParameter("gender");
                  String email=request.getParameter("email");
                    String password=request.getParameter("password");
                      String contact=request.getParameter("contact");
                        String address=request.getParameter("address");
                        
          Publisher pub=new Publisher(fname, lname, email, password, gender, contact, address);
            int pid=new PublisherDao(FactoryProvider.getFactory()).savePublisher(pub);
            
            
            //saved suucessfully
            if(pid>0){
            
                    HttpSession ss = request.getSession();
                        ss.setAttribute("message", "Publisher Added Successfully with id : "+pid);
                        response.sendRedirect("admin.jsp");
            }
            else{
                
                //error
                 HttpSession ss = request.getSession();
                        ss.setAttribute("message", "Something went wrong");
                        response.sendRedirect("error.jsp");
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
