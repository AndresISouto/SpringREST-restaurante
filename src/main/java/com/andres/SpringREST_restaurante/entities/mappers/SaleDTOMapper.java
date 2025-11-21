package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Sale;
import com.andres.SpringREST_restaurante.entities.Sale_Recipe;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeSaleDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleDTO;

@Mapper(componentModel = "spring")
public interface SaleDTOMapper {

  SaleDTO toDto(Sale sale);

  @Mapping(target = "name", source = "recipe.name")
  @Mapping(target = "amount", source = "amount")
  RecipeSaleDTO toRecipeSaleDto(Sale_Recipe sale_recipe);

}
