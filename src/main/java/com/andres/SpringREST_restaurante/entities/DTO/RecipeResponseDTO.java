package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

public record RecipeResponseDTO(
    Long recipe_id,
    String name,
    Integer portions,
    String steps,
    Double precioCoste,
    Double precioVenta,
    List<IngredientResponseDTO> ingredients) {
}
