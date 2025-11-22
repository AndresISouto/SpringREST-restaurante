package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

public record IngredientUpdateDTO(
    Long ingredient_id,
    String name,
    Double amount,
    Unit unit,
    Double pricePerUnit) {
}
