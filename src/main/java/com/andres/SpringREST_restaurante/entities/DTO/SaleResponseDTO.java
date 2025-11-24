package com.andres.SpringREST_restaurante.entities.DTO;

import java.time.LocalDate;
import java.util.List;

import com.andres.SpringREST_restaurante.Enums.State;

public record SaleResponseDTO(
    LocalDate emmisionDate,
    State state,
    Double amount,
    List<RecipeSaleDTO> recipes) {
}
