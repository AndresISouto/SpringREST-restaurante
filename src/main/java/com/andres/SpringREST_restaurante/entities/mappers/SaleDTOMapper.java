package com.andres.SpringREST_restaurante.entities.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Sale;
import com.andres.SpringREST_restaurante.entities.Sale_Recipe;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeSaleDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleResponseDTO;

@Mapper(componentModel = "spring")
public interface SaleDTOMapper {

  @Mapping(target = "recipes", source = "recipes")
  SaleResponseDTO toDto(Sale sale);

  @Mapping(target = "recipes", source = "recipes")
  List<SaleResponseDTO> toDto(List<Sale> sales);

  @Mapping(target = "recipe_id", source = "recipe.recipe_id")
  @Mapping(target = "amount", source = "amount")
  RecipeSaleDTO toRecipeSaleDto(Sale_Recipe sale_recipe);

}
