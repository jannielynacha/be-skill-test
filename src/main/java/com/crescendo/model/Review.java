package com.crescendo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "business_id")
   private Business business;

   @Column
   private String text;

   @Column
   private int rating;

   @Column
   private LocalDateTime createdDate;

   public Review() {
   }

   public Review(Business business, String text, int rating, LocalDateTime createdDate) {
      this.business = business;
      this.text = text;
      this.rating = rating;
      this.createdDate = createdDate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Business getBusiness() {
      return business;
   }

   public void setBusiness(Business business) {
      this.business = business;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public int getRating() {
      return rating;
   }

   public void setRating(int rating) {
      this.rating = rating;
   }

   public LocalDateTime getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(LocalDateTime createdDate) {
      this.createdDate = createdDate;
   }
}
