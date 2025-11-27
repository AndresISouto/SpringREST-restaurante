package com.andres.SpringREST_restaurante.Enums;

public enum Unit {
  Kg(UnitCategory.MASS, 1.0),
  G(UnitCategory.MASS, 0.001),

  L(UnitCategory.VOLUME, 1.0),
  ML(UnitCategory.MASS, 0.001);

  private final UnitCategory category;
  private final Double conversionFactor;

  private Unit(UnitCategory category, Double caonversionFactor) {
    this.category = category;
    this.conversionFactor = caonversionFactor;
  }

  public UnitCategory getCategory() {
    return category;
  }

  public Double getConversionFactor() {
    return conversionFactor;
  }

  public static double convert(Unit unit, double value) {
    if (value < 0) {
      throw new IllegalArgumentException("Value cannot be negative");
    }
    return (value * unit.conversionFactor);
  }

}
