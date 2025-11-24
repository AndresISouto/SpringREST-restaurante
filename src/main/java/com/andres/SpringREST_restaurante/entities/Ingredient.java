package com.andres.SpringREST_restaurante.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.andres.SpringREST_restaurante.entities.VO.Inventory;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
      @AttributeOverride(name = "pricePerUnit", column = @Column(name = "price_per_unit"))
  })
  private Inventory inventory;

  @Column(name = "last_update", nullable = false)
  private LocalDate lastUpdate;

  @ManyToMany
  @JoinTable(name = "ingredients_providers", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "provider_id"))
  private Set<Provider> providers = new HashSet<>();

  @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Recipe_Ingredient> recipes = new HashSet<>();

  public Set<Provider> getProviders() {
    return providers;
  }

  public void setProviders(Set<Provider> providers) {
    this.providers = providers;
  }

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

  public Ingredient(Long ingredient_id, String name, Inventory inventory, LocalDate lastUpdate, Set<Provider> providers,
      Set<Recipe_Ingredient> recipes) {
    this.ingredient_id = ingredient_id;
    this.name = name;
    this.inventory = inventory;
    this.lastUpdate = lastUpdate;
    this.providers = providers;
    this.recipes = recipes;
  }

  public Ingredient(String name, Inventory inventory, LocalDate lastUpdate) {
    this.name = name;
    this.inventory = inventory;
    this.lastUpdate = lastUpdate;
  }

  public Set<Recipe_Ingredient> getRecipes() {
    return recipes;
  }

  public void setRecipes(Set<Recipe_Ingredient> recipes) {
    this.recipes = recipes;
  }

  public void removeProvider(Provider provider) {
    this.providers.remove(provider);
    provider.getIngredients().remove(this);
  }

  public void addProvider(Provider provider) {
    providers.add(provider);
    provider.getIngredients().add(this);
  }
}
