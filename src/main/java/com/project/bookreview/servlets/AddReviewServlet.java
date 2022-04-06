/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.servlets;

import com.project.bookreview.dao.PublisherDao;
import com.project.bookreview.entities.Publisher;
import com.project.bookreview.entities.Review;
import com.project.bookreview.helper.FactoryProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ashut
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class AddReviewServlet extends HttpServlet {

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

            // printing values for testing  
 /*        System.out.println("******started*********");
            Enumeration<String> names = request.getParameterNames();

            while (names.hasMoreElements()) {
                String nn = names.nextElement();
                System.out.println(nn);
                System.out.println("*******values********");
                System.out.println(request.getParameter(nn));
            }
            System.out.println("pic-----" + request.getPart("bookpic").getSubmittedFileName());
            System.out.println("*****ended************");        
*/




           String authorName=request.getParameter("Aname").trim();
           String bookName=request.getParameter("Bname").trim();
           String bookIntro=request.getParameter("Bintro").trim();
           String bookFav=request.getParameter("Bfav").trim();
           String bookAud=request.getParameter("Baud").trim();
            Part part = request.getPart("bookpic");

              HttpSession ss=request.getSession();
           Publisher publisher = (Publisher) ss.getAttribute("publisher");
            
            
            
           
            try {
                  // saving the book image in the folder
                if (part != null) {
                    String path = request.getSession().getServletContext().getRealPath("/") + "img" + File.separator + part.getSubmittedFileName();
               //     System.out.println("paaathhhh--" + path);
                    FileOutputStream fos = new FileOutputStream(path);
                    InputStream is = part.getInputStream();

                    byte[] data = new byte[is.available()];
                    is.read(data);

                    fos.write(data);
                    fos.flush();
                    fos.close();

                    // to genrate random unique book id
                    int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt();
                    // now saving the review in the db
                   
                    PublisherDao pDao=new PublisherDao(FactoryProvider.getFactory());
//                    Publisher publisher =pDao.getPublisherByEmail("a@a");
                    Review rev=new  Review(randomWithThreadLocalRandom, authorName, bookName, part.getSubmittedFileName(), bookIntro, bookFav, bookAud, publisher)   ;
                    
                    int Rid=pDao.addReview(rev);
                    
                    
                    if(Rid>0){
                        out.println("sucess");
                    }
                    else{
                        // review not added error
                        out.println("error");
                    }
                } else {
//                     errror 
                    //response.sendRedirect("/MYSITE/error_page.jsp");
                }

            } catch (IOException e) {
                e.printStackTrace();
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
