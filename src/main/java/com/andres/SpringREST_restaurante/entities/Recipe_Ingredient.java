package com.andres.SpringREST_restaurante.entities;

import com.andres.SpringREST_restaurante.Enums.Unit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes_ingredients")
public class Recipe_Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long recipe_ingredient_id;
  @ManyToOne
  @JoinColumn(name = "recipe_id", nullable = false)
  private Recipe recipe;
  @ManyToOne
  @JoinColumn(name = "ingredient_id", nullable = false)
  private Ingredient ingredient;

  private Double amount;
  private Unit unit;

  public Long getRecipe_ingredient_id() {
    return recipe_ingredient_id;
  }

  public void setRecipe_ingredient_id(Long recipe_ingredient_id) {
    this.recipe_ingredient_id = recipe_ingredient_id;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public Ingredient getIngredient() {
    return ingredient;
  }

  public void setIngredient(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public Recipe_Ingredient() {
  }

  public Recipe_Ingredient(Long recipe_ingredient_id, Recipe recipe, Ingredient ingredient, Double amount, Unit unit) {
    this.recipe_ingredient_id = recipe_ingredient_id;
    this.recipe = recipe;
    this.ingredient = ingredient;
    this.amount = amount;
    this.unit = unit;
  }

  public Recipe_Ingredient(Recipe recipe, Ingredient ingredient, Double amount, Unit unit) {
    this.recipe = recipe;
    this.ingredient = ingredient;
    this.amount = amount;
    this.unit = unit;
  }

}
