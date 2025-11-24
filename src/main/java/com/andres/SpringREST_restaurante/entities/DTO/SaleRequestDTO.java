package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

public record SaleRequestDTO(
    List<RecipeSaleDTO> recipes) {
}
