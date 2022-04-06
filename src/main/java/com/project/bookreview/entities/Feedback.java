/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ashut
 */
@Entity
        @Table(name="User_Feedbacks")
public class Feedback {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
      
    
    @Column(length = 500, name = "user_feedback",nullable = false)
    private String userFeedback;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_ID",nullable = false)
      private User user;
    
    
    
    @Column(name = "review_id",nullable = false )
    private int reviewId;

    public Feedback() {
    }

    
    
    public Feedback(String userFeedback, User user, int bookId) {
        this.userFeedback = userFeedback;
        this.user = user;
        this.reviewId = bookId;
    }

    
    
    
    
    public String getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + Id + ", userFeedback=" + userFeedback + ", user=" + user + ", reviewId=" + reviewId + '}';
    }
    
    
    
    
    
}
