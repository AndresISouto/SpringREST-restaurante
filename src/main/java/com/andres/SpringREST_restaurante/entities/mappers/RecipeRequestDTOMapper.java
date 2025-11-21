package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientBasicDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeRequestDTO;

@Mapper(componentModel = "spring")
public interface RecipeRequestDTOMapper {

  @Mapping(target = "ingredients", ignore = true)
  Recipe toEntity(RecipeRequestDTO dto);

}
