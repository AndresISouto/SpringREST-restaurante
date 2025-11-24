package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleResponseDTO;

@Service
public interface IsaleService {

  List<SaleResponseDTO> getAll();

  SaleResponseDTO getById(Long id);

  void deleteById(Long id);

  SaleResponseDTO create(SaleRequestDTO dto);

  RecipeResponseDTO addRecipeById(Long saleId, Long recipeId);

  void removeRecipeById(Long saleId, Long recipeId);

  Double calculateAmount(Long id);

}
