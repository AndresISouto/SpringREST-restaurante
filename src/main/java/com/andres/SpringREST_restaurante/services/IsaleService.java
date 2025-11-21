package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleDTO;

@Service
public interface IsaleService {

  List<SaleDTO> getAll();

  SaleDTO getById(Long id);

  void deleteById(Long id);

  SaleDTO create();

  RecipeResponseDTO addRecipeById(Long Id);

  RecipeResponseDTO removeRecipeById(Long Id);

  Double calculateAmount();

}
