package com.andres.SpringREST_restaurante.entities.DTO;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Positive;

public record RecipeSaleDTO(
    @NonNull @Positive Long recipe_id,
    @NonNull @Positive Integer amount) {
}
