package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeUpdateDTO;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

  @Mapping(target = "ingredients", source = "ingredients")
  RecipeResponseDTO toDto(Recipe recipe);

  @Mapping(target = "name", source = "ingredient.name")
  @Mapping(target = "amount", source = "amount")
  @Mapping(target = "unit", source = "unit")
  @Mapping(target = "ingredient_id", source = "ingredient.ingredient_id")
  IngredientResponseDTO toIngredientDto(Recipe_Ingredient recipeIngredient);

  @Mapping(target = "ingredients", ignore = true)
  @Mapping(target = "recipe_id", ignore = true)
  @Mapping(target = "precioCoste", ignore = true)
  @Mapping(target = "reviews", ignore = true)
  @Mapping(target = "sales", ignore = true)
  Recipe toEntity(RecipeRequestDTO dto);

  @Mapping(target = "ingredients", ignore = true)
  @Mapping(target = "precioCoste", ignore = true)
  @Mapping(target = "reviews", ignore = true)
  @Mapping(target = "sales", ignore = true)
  Recipe toEntity(RecipeUpdateDTO dto);
}
