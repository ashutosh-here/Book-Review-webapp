/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookreview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author ashut
 */
@Entity
        @Table(name = "Admin_table")
public class Admin {
    
    
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
       
    @Column(length = 100, name = "admin_name" , nullable = false)
    private String adminName;
    
    @Column(length = 100, name = "admin_email",unique = true,nullable = false )
    private String adminEmail;
    
    @Column(length = 100, name = "admin_password",nullable = false)
    private String adminPassword;
    
   
    @Column(length = 20, name = "admin_gender")
    private String adminGender;

    public Admin( String adminName, String adminEmail, String adminPassword, String adminGender) {
    
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminGender = adminGender;
    }

    public Admin() {
    }

    public int getAdminId() {
        return adminId;
    }

  

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender;
    }

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + ", adminGender=" + adminGender + '}';
    }
    


    
    
    
    
    
    
    
}
