package com.andres.SpringREST_restaurante.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long provider_id;
  @Column(nullable = false, length = 100)
  private String name;

  @ManyToMany(mappedBy = "providers", cascade = CascadeType.ALL)
  private Set<Ingredient> ingredients = new HashSet<>();

  public Long getProvider_id() {
    return provider_id;
  }

  public Provider(String name, Set<Ingredient> ingredientes) {
    this.name = name;
    this.ingredients = ingredientes;
  }

  public Provider(Long provider_id, String name, Set<Ingredient> ingredientes) {
    this.provider_id = provider_id;
    this.name = name;
    this.ingredients = ingredientes;
  }

  public void setProvider_id(Long provider_id) {
    this.provider_id = provider_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<Ingredient> ingredientes) {
    this.ingredients = ingredientes;
  }

  public Provider() {
  }

}
