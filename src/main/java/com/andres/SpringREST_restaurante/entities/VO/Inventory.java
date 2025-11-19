package com.andres.SpringREST_restaurante.entities.VO;

import com.andres.SpringREST_restaurante.Enums.Unit;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Inventory {

  private final Double amount;
  @Enumerated(EnumType.STRING)
  private final Unit unit;
  private final Double pricePerUnit;

  public Inventory() {
    this.amount = null;
    this.unit = null;
    this.pricePerUnit = null;
  }

  public Inventory(Double amount, Unit unit, Double pricePerUnit) {

    if (amount < 0 || amount == null) {
      throw new IllegalArgumentException("not null or negative prices");
    }
    if (pricePerUnit < 0 || pricePerUnit == null) {
      throw new IllegalArgumentException("not null or negative prices per unit");
    }
    this.amount = amount;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((unit == null) ? 0 : unit.hashCode());
    result = prime * result + ((pricePerUnit == null) ? 0 : pricePerUnit.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Inventory other = (Inventory) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (unit != other.unit)
      return false;
    if (pricePerUnit == null) {
      if (other.pricePerUnit != null)
        return false;
    } else if (!pricePerUnit.equals(other.pricePerUnit))
      return false;
    return true;
  }

  public Double getAmount() {
    return amount;
  }

  public Unit getUnit() {
    return unit;
  }

  public Double getPricePerUnit() {
    return pricePerUnit;
  }

}
