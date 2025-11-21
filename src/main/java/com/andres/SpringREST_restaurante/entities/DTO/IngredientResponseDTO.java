package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

public record IngredientResponseDTO(
    Long ingredient_id,
    String name,
    Integer amount,
    Unit unit,
    Double pricePerUnit) {
}
