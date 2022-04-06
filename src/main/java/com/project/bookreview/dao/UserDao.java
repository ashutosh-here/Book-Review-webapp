/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.dao;

import com.project.bookreview.entities.*;
import com.project.bookreview.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ashut
 */
public class UserDao {
 


    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    
    public boolean ifUserExists(String email){
     
        
         User user=null;
     
           String query="from User where userEmail =:e"; 
            Session session=this.factory.openSession();
            
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            user=(User) q.uniqueResult();
            session.close();
            
       
         
     
         
        return user!=null;
    }
    
    
    
    public int saveUser(User user){
     
        int uId=Integer.MIN_VALUE;
        
        try{
           Session ss=this.factory.openSession();
      Transaction tx=ss.beginTransaction();
          uId  =    (int) ss.save(user);
       tx.commit();
       ss.close();
  
           } catch (HibernateException e) {
            e.printStackTrace();
        }
        return uId;
    }
    
    
        //get user by email and passowrd for login verification
    public  User getUserByEmailAndPassword(String email, String password){
      
       User user=null;
        
        try {
            
           String query="from User where userEmail =:e and userPassword =:p"; 
            
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p", password);
            user=(User)q.uniqueResult();
            session.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        
        
        
        return user;
       
        
    }
    
          //get user by email 
    public  User getUserByEmail(String email){
      
       User user=null;
        
        try {
            
           String query="from User where userEmail =:e"; 
            
            Session session=this.factory.openSession();
            Query q=session.createQuery(query);
            q.setParameter("e", email);
            user=(User)q.uniqueResult();
            session.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        
        
        
        return user;
       
        
    }
    
    
 public int saveRatingFeedback(Rating rating,Feedback feedback){
     
        int rId=-1999;
        int fId=-1999;
        try{
           Session ss=this.factory.openSession();
      Transaction tx=ss.beginTransaction();
          rId  =    (int) ss.save(rating);
          fId  =    (int) ss.save(feedback);
       tx.commit();
       ss.close();
  
           } catch (HibernateException e) {
            e.printStackTrace();
        }
        return rId+fId;
    }    
    
    
    
    
    
    
    
    
    
    
}
