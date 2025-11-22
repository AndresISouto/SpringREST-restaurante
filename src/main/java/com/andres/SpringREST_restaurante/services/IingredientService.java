package com.andres.SpringREST_restaurante.services;

import java.util.List;
import java.util.Set;

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

  Set<ProviderDTO> getProvidersById(Long id);

  ProviderDTO addProvider(Long ingredient_id, Long provider_id);

  void removeProvider(Long ingredient_id, Long provider_id);
}
