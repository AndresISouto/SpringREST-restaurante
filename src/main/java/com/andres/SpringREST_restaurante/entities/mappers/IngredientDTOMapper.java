package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientDTO;

@Mapper(componentModel = "spring")
public interface IngredientDTOMapper {

  @Mapping(target = "amount", source = "inventory.amount")
  @Mapping(target = "unit", source = "inventory.unit")
  @Mapping(target = "pricePerUnit", source = "inventory.pricePerUnit")
  IngredientDTO toDto(Ingredient dto);

}
