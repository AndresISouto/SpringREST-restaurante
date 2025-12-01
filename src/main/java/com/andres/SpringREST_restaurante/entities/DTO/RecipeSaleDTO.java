package com.andres.SpringREST_restaurante.entities.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RecipeSaleDTO(
    @NotNull @Positive Long recipe_id,
    @NotNull @Positive Integer amount) {
}
