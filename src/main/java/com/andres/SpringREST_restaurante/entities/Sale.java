package com.andres.SpringREST_restaurante.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.andres.SpringREST_restaurante.Enums.State;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sale_id;
  @Column(name = "emmision_date", nullable = false)
  private LocalDate emmisionDate;
  @Column(nullable = false)
  private State state;
  @Column(nullable = false)
  private Double amount;

  @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Sale_Recipe> recipes = new HashSet<>();

  public Long getSale_id() {
    return sale_id;
  }

  public void setSale_id(Long sale_id) {
    this.sale_id = sale_id;
  }

  public LocalDate getEmmisionDate() {
    return emmisionDate;
  }

  public void setEmmisionDate(LocalDate emmisionDate) {
    this.emmisionDate = emmisionDate;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Set<Sale_Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(Set<Sale_Recipe> recipes) {
    this.recipes = recipes;
  }

  public Sale() {
  }

  public Sale(Long sale_id, LocalDate emmisionDate, State state, Double amount, Set<Sale_Recipe> recipes) {
    this.sale_id = sale_id;
    this.emmisionDate = emmisionDate;
    this.state = state;
    this.amount = amount;
    this.recipes = recipes;
  }

  public Sale(LocalDate emmisionDate, State state, Double amount) {
    this.emmisionDate = emmisionDate;
    this.state = state;
    this.amount = amount;
  }

}
