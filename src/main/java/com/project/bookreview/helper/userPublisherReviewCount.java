/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.helper;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ashut
 */
public class userPublisherReviewCount {
    
    
      public static Map<String,Long> getCounts(){
        
        Session ss=FactoryProvider.getFactory().openSession();
        String q1="Select count(*) from User";
        String q2="Select count(*) from Publisher";
        String q3="Select count(*) from Review";
        
        Query query1=ss.createQuery(q1);
        Query query2=ss.createQuery(q2);
        Query query3=ss.createQuery(q3);
        
        Long userCount=(Long)query1.list().get(0);
        Long publisherCount=(Long)query2.list().get(0);
        Long reviewCount=(Long)query3.list().get(0);
        
        Map<String , Long> map = new HashMap<>();
        map.put("userCount", userCount);
        map.put("publisherCount", publisherCount);
        map.put("reviewCount", reviewCount);
        
        return map;
        
    }
    
    
    
}
