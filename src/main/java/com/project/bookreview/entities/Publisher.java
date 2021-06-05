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
        @Table(name="Publisher_table")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;
    
    
       
    @Column(length = 100, name = "publisher_Fname" , nullable = false)
    private String publisherFname;
    
     @Column(length = 100, name = "publisher_Lname" )
    private String publisherLname;
    
    @Column(length = 100, name = "publisher_email",unique = true,nullable = false )
    private String publisherEmail;
    
    @Column(length = 100, name = "publisher_password",nullable = false)
    private String publisherPassword;
    
   
    @Column(length = 20, name = "publisher_gender")
    private String publisherGender;
    
    @Column(length = 100, name = "publisher_contact",nullable = false)
    private String publisherContact;
    
    @Column(length = 100, name = "publisher_address",nullable = false)
    private String publisherAddress;
    
    
    
     @OneToMany(mappedBy = "publisher")
    private List<Review> publisherReviews = new ArrayList<>();
    
    public List<Review> getPublisherReviews() {
        return publisherReviews;
    }

    public void setPublisherReviews(List<Review> publisherReviews) {
        this.publisherReviews = publisherReviews;
    }
    
    

    public Publisher( String publisherFname, String publisherLname, String publisherEmail, String publisherPassword, String publisherGender, String publisherContact, String publisherAddress) {
 
        this.publisherFname = publisherFname;
        this.publisherLname = publisherLname;
        this.publisherEmail = publisherEmail;
        this.publisherPassword = publisherPassword;
        this.publisherGender = publisherGender;
        this.publisherContact = publisherContact;
        this.publisherAddress = publisherAddress;
    }

    public Publisher() {
    }

    public int getPublisherId() {
        return publisherId;
    }



    public String getPublisherFname() {
        return publisherFname;
    }

    public void setPublisherFname(String publisherFname) {
        this.publisherFname = publisherFname;
    }

    public String getPublisherLname() {
        return publisherLname;
    }

    public void setPublisherLname(String publisherLname) {
        this.publisherLname = publisherLname;
    }

    public String getPublisherEmail() {
        return publisherEmail;
    }

    public void setPublisherEmail(String publisherEmail) {
        this.publisherEmail = publisherEmail;
    }

    public String getPublisherPassword() {
        return publisherPassword;
    }

    public void setPublisherPassword(String publisherPassword) {
        this.publisherPassword = publisherPassword;
    }

    public String getPublisherGender() {
        return publisherGender;
    }

    public void setPublisherGender(String publisherGender) {
        this.publisherGender = publisherGender;
    }

    public String getPublisherContact() {
        return publisherContact;
    }

    public void setPublisherContact(String publisherContact) {
        this.publisherContact = publisherContact;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    @Override
    public String toString() {
        return "Publisher{" + "publisherId=" + publisherId + ", publisherFname=" + publisherFname + ", publisherLname=" + publisherLname + ", publisherEmail=" + publisherEmail + ", publisherPassword=" + publisherPassword + ", publisherGender=" + publisherGender + ", publisherContact=" + publisherContact + ", publisherAddress=" + publisherAddress + '}';
    }
    
    
    
    
    
    
}
