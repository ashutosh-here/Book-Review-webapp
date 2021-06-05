/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ashut
 */
public class FactoryProvider {
    
   public static SessionFactory factory;
    
    public static SessionFactory getFactory(){
        
        if (factory==null) {
       
          
            factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//    
//        try{
//         factory = cfg.buildSessionFactory();
//        }catch(HibernateException ex){
//            ex.printStackTrace();
//        }
        
        }
        return factory;
        
    }
    
    
    public void closeFactory(){
    
        if(factory.isOpen()){
            factory.close();
        }
        
        
}
    
    
 //  testing 
    public static void main(String[] args) {
        SessionFactory sf=FactoryProvider.getFactory();
        System.out.println(sf);
    }
    
    
    
    
    
}
