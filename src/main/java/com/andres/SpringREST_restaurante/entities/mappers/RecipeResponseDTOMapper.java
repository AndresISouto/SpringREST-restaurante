package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;

@Mapper(componentModel = "spring")
public interface RecipeResponseDTOMapper {

  // 1. Main mapping: Recipe -> RecipeResponseDTO
  // MapStruct automatically detects the Set -> List conversion for 'ingredients'
  @Mapping(target = "ingredients", source = "ingredients")
  RecipeResponseDTO toDto(Recipe recipe);

  // 2. Helper mapping: Recipe_Ingredient -> IngredientResponseDTO
  // This runs automatically for every item in the Set
  @Mapping(target = "name", source = "ingredient.name") // Jump from Link -> Ingredient -> Name
  @Mapping(target = "amount", source = "amount") // Directly from Link
  @Mapping(target = "unit", source = "unit") // Directly from Link (Enums map to String auto)
  IngredientDTO toIngredientDto(Recipe_Ingredient recipeIngredient);

}
