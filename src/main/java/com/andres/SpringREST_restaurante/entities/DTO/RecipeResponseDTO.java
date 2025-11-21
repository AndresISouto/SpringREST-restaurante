package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

public record RecipeResponseDTO(
    String name,
    Integer portions,
    String steps,
    Double precioCoste,
    Double precioVenta,
    List<IngredientDTO> ingredients) {
}
