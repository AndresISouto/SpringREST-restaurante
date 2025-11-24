package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RecipeIngredientDTO(
    @NotNull @Positive Long ingredient_id,
    @NotNull Unit unit,
    @NotNull @Positive Double amount) {
}
