/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ashut
 */
@Entity
@Table(name="user_table")
public class User {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length = 100, name = "user_name", nullable = false)
    private String userName;
    
    
    @Column(length = 100, name = "user_email",unique = true, nullable = false )
    private String userEmail;
    
    @Column(length = 100, name = "user_password", nullable = false)
    private String userPassword;

    @Column(length = 20, name = "user_gender")
    private String userGender;

    @Column(length = 100, name = "user_address")
    private String userAddress;

    
    
       @OneToMany(mappedBy = "user")
    private List<Feedback> userFeedbacks = new ArrayList<>();
    
    public List<Feedback> getUserFeedbacks() {
        return userFeedbacks;
    }

    public void setUserFeedbacks(List<Feedback> userFeedbacks) {
        this.userFeedbacks = userFeedbacks;
    }
    
     @OneToMany(mappedBy = "user")
    private List<Rating> userRatings= new ArrayList<>();
    
    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }
    

    
    
    
    public User(String userName, String userEmail, String userPassword, String userGender, String userAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userAddress = userAddress;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userGender=" + userGender + ", userAddress=" + userAddress + '}';
    }
    
   
    
    
    
    
    
}
