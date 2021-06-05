/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.dao;

import com.project.bookreview.entities.Publisher;
import com.project.bookreview.entities.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ashut
 */
public class PublisherDao {
    
    
    
      private SessionFactory factory;

    public PublisherDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    
    
    
    
    
     public boolean isPublisher(String email){
     
        
         Publisher pub=null;
     
           String query="from Publisher where publisherEmail =:e"; 
            Session session=this.factory.openSession();
            
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            pub=(Publisher) q.uniqueResult();
            session.close();
            
       
         
     
         
        return pub!=null;
    }
    
     // get publisher by unique email id
     public Publisher getPublisherByEmail(String email){
         Publisher pub=null;
         
         
           String query="from Publisher where publisherEmail =:e"; 
            Session session=this.factory.openSession();
            
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            pub=(Publisher) q.uniqueResult();
            session.close();
         
         
         
         
         
         return pub;
        
     }
     
    
      //get publisher by email and passowrd for login verification
    public   Publisher getPublisherByEmailAndPassword(String email, String password){
      
       Publisher pub=null;
        
        try {
            
           String query="from Publisher where publisherEmail =:e and publisherPassword =:p"; 
            
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p", password);
            pub=(Publisher)q.uniqueResult();
            session.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        
        
        
        return pub;
       
        
    }
     
    
     
    public int savePublisher(Publisher publisher){
     
        int pId=Integer.MIN_VALUE;
        
        try{
           Session ss=this.factory.openSession();
      Transaction tx=ss.beginTransaction();
          pId  =    (int) ss.save(publisher);
       tx.commit();
       ss.close();
  
           } catch (HibernateException e) {
            e.printStackTrace();
        }
        return pId;
    }
    
     
     
     
     // method to add review  by a publisher
     public int addReview(Review rev){



        int rId=Integer.MIN_VALUE;
        
        try{
           Session ss=this.factory.openSession();
      Transaction tx=ss.beginTransaction();
          rId  =    (int) ss.save(rev);
       tx.commit();
       ss.close();
  
           } catch (HibernateException e) {
            e.printStackTrace();
        }
        return rId;




}

     
     
     
     
     
     
     
     
     
     
     
}



