package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;

@Service
public interface IingredientService {

  List<IngredientResponseDTO> getAll();

  IngredientResponseDTO getById(Long id);

  void deleteById(Long id);

  IngredientResponseDTO create(IngredientRequestDTO dto);

  IngredientResponseDTO update(IngredientUpdateDTO dto);

  ProviderDTO getProvidersById(Long id);
}
