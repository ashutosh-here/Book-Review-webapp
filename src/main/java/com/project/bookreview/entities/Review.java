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
@Table(name = "Publisher_review")
public class Review {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int reviewId;
      
       @Column(name = "book_id",nullable = false )
    private int bookId;
     
    @Column(length = 100, name = "author_name" , nullable = false)
    private String authorName;
    
      @Column(length = 100, name = "book_name" , nullable = false)
    private String bookName;
      
     @Column(length = 100, name = "book_image",nullable = false )
    private String bookImage;
    
   //book review contents
     
     // what is this book about
      @Column(length = 500, name = "book_intro",nullable = false )
    private String bookIntro;
      
      //what was ur favourite part of the book
      @Column(length = 500, name = "book_fav_part",nullable = false )
    private String bookFavPart;
      
      //who do u recommend this book or audience of this book
      @Column(length = 500, name = "book_audience",nullable = false )
    private String bookAudience;
    
    
    
       @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Publisher_ID")
      private Publisher publisher;

    public Review() {
    }

 



    public Review(int bookId, String authorName, String bookName, String bookImage, String bookIntro, String bookFavPart, String bookAudience, Publisher publisher) {
        this.bookId = bookId;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookIntro = bookIntro;
        this.bookFavPart = bookFavPart;
        this.bookAudience = bookAudience;
        this.publisher = publisher;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public String getBookFavPart() {
        return bookFavPart;
    }

    public void setBookFavPart(String bookFavPart) {
        this.bookFavPart = bookFavPart;
    }

    public String getBookAudience() {
        return bookAudience;
    }

    public void setBookAudience(String bookAudience) {
        this.bookAudience = bookAudience;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewId=" + reviewId + ", authorName=" + authorName + ", bookImage=" + bookImage + ", bookIntro=" + bookIntro + ", bookFavPart=" + bookFavPart + ", bookAudience=" + bookAudience + ", publisher=" + publisher + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
