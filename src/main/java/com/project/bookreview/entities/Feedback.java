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
        @Table(name="User_Feedback")
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
	@JoinColumn(name = "User_ID")
      private User user;
    
    
    
    @Column(name = "book_id",unique = true,nullable = false )
    private int bookId;

    public Feedback() {
    }

    
    
    public Feedback(String userFeedback, User user, int bookId) {
        this.userFeedback = userFeedback;
        this.user = user;
        this.bookId = bookId;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + Id + ", userFeedback=" + userFeedback + ", user=" + user + ", bookId=" + bookId + '}';
    }
    
    
    
    
    
}
