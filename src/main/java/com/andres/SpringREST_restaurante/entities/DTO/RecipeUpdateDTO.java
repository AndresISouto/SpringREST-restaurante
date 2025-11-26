package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RecipeUpdateDTO(
    @NotNull @Positive Long recipe_id,
    @NotBlank String name,
    @NotNull @Positive Integer portions,
    @NotBlank String steps,
    @NotEmpty @Valid List<RecipeIngredientDTO> ingredients) {
}
