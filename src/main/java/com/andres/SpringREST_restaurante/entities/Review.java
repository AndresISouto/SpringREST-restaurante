package com.andres.SpringREST_restaurante.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long review_id;

  @Lob
  @Column(nullable = false)
  private String body;

  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = false)
  private Recipe recipe;

  public Review() {
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public Long getReview_id() {
    return review_id;
  }

  public void setReview_id(Long review_id) {
    this.review_id = review_id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Review(Long review_id, String body, Recipe recipe) {
    this.review_id = review_id;
    this.body = body;
    this.recipe = recipe;
  }

  public Review(String body, Recipe recipe) {
    this.body = body;
    this.recipe = recipe;
  }

}
