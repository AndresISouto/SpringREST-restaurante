package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

import jakarta.validation.Valid;

public record SaleRequestDTO(
    @Valid List<RecipeSaleDTO> recipes) {
}
