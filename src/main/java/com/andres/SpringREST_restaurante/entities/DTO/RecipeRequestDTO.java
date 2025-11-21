package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

public record RecipeRequestDTO(
    String name,
    Integer portions,
    String steps,
    Double precioVenta,
    List<IngredientBasicDTO> ingredients) {
}
