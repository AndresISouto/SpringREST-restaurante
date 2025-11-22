package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

public record IngredientRequestDTO(
    String name,
    Double amount,
    Unit unit,
    Double pricePerUnit) {
}
