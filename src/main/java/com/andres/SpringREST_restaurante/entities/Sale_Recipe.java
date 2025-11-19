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

}
