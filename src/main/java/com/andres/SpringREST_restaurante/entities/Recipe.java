package com.andres.SpringREST_restaurante.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long recipe_id;
  @Column(nullable = false, length = 100)
  private String name;
  @Column(nullable = false)
  private Integer portions;
  @Lob
  @Column(nullable = false)
  private String steps;
  @Column(nullable = false)
  private Double precioCoste;
  @Column(nullable = false)
  private Double precioVenta;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Recipe_Ingredient> ingredients = new HashSet<>();

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Review> reviews = new HashSet<>();

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Sale_Recipe> sales = new HashSet<>();

  public Set<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Set<Review> reviews) {
    this.reviews = reviews;
  }

  public Long getRecipe_id() {
    return recipe_id;
  }

  public void setRecipe_id(Long recipe_id) {
    this.recipe_id = recipe_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPortions() {
    return portions;
  }

  public void setPortions(Integer portions) {
    this.portions = portions;
  }

  public String getSteps() {
    return steps;
  }

  public void setSteps(String steps) {
    this.steps = steps;
  }

  public Double getPrecioCoste() {
    return precioCoste;
  }

  public void setPrecioCoste(Double precioCoste) {
    this.precioCoste = precioCoste;
  }

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public Recipe() {
  }

  public Recipe(Long recipe_id, String name, Integer portions, String steps, Double precioCoste, Double precioVenta,
      Set<Recipe_Ingredient> ingredients, Set<Review> reviews, Set<Sale_Recipe> sales) {
    this.recipe_id = recipe_id;
    this.name = name;
    this.portions = portions;
    this.steps = steps;
    this.precioCoste = precioCoste;
    this.precioVenta = precioVenta;
    this.ingredients = ingredients;
    this.reviews = reviews;
    this.sales = sales;
  }

  public Recipe(String name, Integer portions, String steps, Double precioCoste, Double precioVenta) {
    this.name = name;
    this.portions = portions;
    this.steps = steps;
    this.precioCoste = precioCoste;
    this.precioVenta = precioVenta;
  }

  public Set<Recipe_Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<Recipe_Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Set<Sale_Recipe> getSales() {
    return sales;
  }

  public void setSales(Set<Sale_Recipe> sales) {
    this.sales = sales;
  }

}
