package com.andres.SpringREST_restaurante.entities.DTO;

import com.andres.SpringREST_restaurante.Enums.Unit;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record IngredientRequestDTO(
    @NotNull @NotBlank String name,
    @NotNull @Positive Double amount,
    @NotNull Unit unit,
    @NotNull @Positive Double pricePerUnit) {
}
