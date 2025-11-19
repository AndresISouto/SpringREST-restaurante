package com.andres.SpringREST_restaurante.entities;

import java.time.LocalDate;

import com.andres.SpringREST_restaurante.entities.VO.Inventory;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ingredient_id;
  @Column(nullable = false, length = 100)
  private String name;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "amount", column = @Column(name = "amount", scale = 2)),
      @AttributeOverride(name = "unit", column = @Column(name = "unit")),
      @AttributeOverride(name = "price_per_unit", column = @Column(name = "pricePerUnit"))
  })
  private Inventory inventory;

  @Column(name = "last_update", nullable = false)
  private LocalDate lastUpdate;

  public Long getIngredient_id() {
    return ingredient_id;
  }

  public void setIngredient_id(Long ingredient_id) {
    this.ingredient_id = ingredient_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  public LocalDate getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(LocalDate lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public Ingredient() {
  }

}
