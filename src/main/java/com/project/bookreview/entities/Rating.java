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
@Table(name="User_Ratings")
public class Rating {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

  
    
    
    
    @Column(name = "user_rating",nullable = false)
    private byte userRating;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_ID",nullable = false)
      private User user;
    
    
    
    @Column(name = "review_id",nullable = false )
    private int reviewId;

    public Rating() {
    }

    
    
    
    
    public Rating(byte userRating, User user, int reviewId) {
        this.userRating = userRating;
        this.user = user;
        this.reviewId = reviewId;
    }

    public byte getUserRating() {
        return userRating;
    }

    public void setUserRating(byte userRating) {
        this.userRating = userRating;
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
        return "Rating{" + "id=" +id + ", userRating=" + userRating + ", user=" + user + ", reviewId=" + reviewId + '}';
    }

    
    
    
    
}
