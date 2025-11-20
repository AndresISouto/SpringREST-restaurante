package com.andres.SpringREST_restaurante.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_recipes")
public class Sale_Recipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sale_recipe_id;

  @ManyToOne
  @JoinColumn(name = "sale_id", nullable = false)
  private Sale sale;
  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = false)
  private Recipe recipe;

  private Integer amount;

  public Long getSale_recipe_id() {
    return sale_recipe_id;
  }

  public void setSale_recipe_id(Long sale_recipe_id) {
    this.sale_recipe_id = sale_recipe_id;
  }

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Sale_Recipe() {
  }

  public Sale_Recipe(Long sale_recipe_id, Sale sale, Recipe recipe, Integer amount) {
    this.sale_recipe_id = sale_recipe_id;
    this.sale = sale;
    this.recipe = recipe;
    this.amount = amount;
  }

  public Sale_Recipe(Sale sale, Recipe recipe, Integer amount) {
    this.sale = sale;
    this.recipe = recipe;
    this.amount = amount;
  }

}
