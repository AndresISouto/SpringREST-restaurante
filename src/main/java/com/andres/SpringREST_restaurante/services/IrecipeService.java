package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.DTO.RecipeRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeUpdateDTO;

@Service
public interface IrecipeService {

  List<RecipeResponseDTO> getAll();

  RecipeResponseDTO getById(Long id);

  void deleteById(Long id);

  RecipeResponseDTO create(RecipeRequestDTO dto);

  RecipeResponseDTO update(RecipeUpdateDTO dto);

}
