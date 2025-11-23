package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

public record RecipeIngredientDTO(
    Long ingredient_id,
    Unit unit,
    Double amount) {
}
