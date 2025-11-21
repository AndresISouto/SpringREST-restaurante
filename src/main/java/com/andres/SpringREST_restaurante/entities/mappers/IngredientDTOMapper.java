package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientUpdateDTO;

@Mapper(componentModel = "spring")
public interface IngredientDTOMapper {

  @Mapping(target = "amount", source = "inventory.amount")
  @Mapping(target = "unit", source = "inventory.unit")
  @Mapping(target = "pricePerUnit", source = "inventory.pricePerUnit")
  IngredientResponseDTO toDto(Ingredient ingredient);

  @Mapping(target = "inventory", expression = "java(new Inventory(dto.amount(),dto.unit(),dto.pricePerUnit()))")
  Ingredient toEntity(IngredientRequestDTO dto);

  @Mapping(target = "inventory", expression = "java(new Inventory(dto.amount(),dto.unit(),dto.pricePerUnit()))")
  Ingredient toEntity(IngredientUpdateDTO dto);
}
