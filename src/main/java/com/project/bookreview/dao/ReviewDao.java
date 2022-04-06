/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.dao;

import com.project.bookreview.entities.Review;
import com.project.bookreview.entities.Rating;
import com.project.bookreview.entities.Feedback;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author ashut
 */
public class ReviewDao {
    
    
    
      private SessionFactory factory;

    public ReviewDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    
  public List<Review> getAllReviews(){
   
      Session s=this.factory.openSession();
      Query query=s.createQuery("from Review");
      List<Review> list=query.list();
      
      s.close();
      
      return list;
      
  }  
    
//  get  all review by review id
     public Review getrReviewById(int rid){

          Review review=null;

      Session s=this.factory.openSession();
        Query q=s.createQuery("from Review as p where p.reviewId =:id");
        q.setParameter("id", rid);
       review=(Review) q.uniqueResult();
       
        
s.close();

return review;

}   
   
     
     
      
    // get all reviews  of given publisher
     public  List<Review> getAllReviewsById( int pid ){
        Session s=this.factory.openSession();
        Query q=s.createQuery("from Review as r where r.publisher.publisherId =:id");
        q.setParameter("id", pid);
        List<Review> list=q.list();
        
        
        return list;
        
    }
     
     // get all ratings on a review using review id
  public List<Rating>   getRatingOnReviewById(int rid){
       Session s=this.factory.openSession();
        Query q=s.createQuery("from Rating as r where r.reviewId=:id");
        q.setParameter("id", rid);
        List<Rating> list=q.list();
        
        
        return list;  
         
         
         
         
     }
     
   // get all feedbacks on a review using review id
  public List<Feedback>   getFeedbacksOnReviewById(int rid){
       Session s=this.factory.openSession();
        Query q=s.createQuery("from Feedback as f where f.reviewId =:id");
        q.setParameter("id", rid);
        List<Feedback> list=q.list();
        
        
        return list;  
         
         
         
         
     }   
     
     
}
