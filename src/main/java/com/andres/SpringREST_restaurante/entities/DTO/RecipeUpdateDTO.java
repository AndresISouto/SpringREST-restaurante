package com.andres.SpringREST_restaurante.entities.DTO;

import java.util.List;

public record RecipeUpdateDTO(
    Long recipe_id,
    String name,
    Integer portions,
    String steps,
    Double precioVenta,
    List<RecipeIngredientDTO> ingredients) {
}
