package com.andres.SpringREST_restaurante.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ReviewDTO;
import com.andres.SpringREST_restaurante.services.RecipeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class RecipeController {

  private final RecipeServiceImpl recipeService;

  public RecipeController(RecipeServiceImpl recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping("/v1/recipes")
  public ResponseEntity<List<RecipeResponseDTO>> getAll() {
    List<RecipeResponseDTO> recipes = recipeService.getAll();
    return ResponseEntity.ok(recipes); // 200 OK
  }

  @GetMapping("/vi/recipes/{id}")
  public ResponseEntity<RecipeResponseDTO> getById(@PathVariable Long id) {
    RecipeResponseDTO response = recipeService.getById(id);
    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/v1/recipes/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    recipeService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/v1/recipes")
  public ResponseEntity<RecipeResponseDTO> create(@RequestBody @Valid RecipeRequestDTO dto) {
    RecipeResponseDTO response = recipeService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PostMapping("/v1/recipes/{id}")
  public ResponseEntity<RecipeResponseDTO> update(@RequestBody @Valid RecipeUpdateDTO dto) {
    RecipeResponseDTO response = recipeService.update(dto);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/v1/recipes/{id}/reviews")
  public ResponseEntity<List<ReviewDTO>> getReviewsById(@PathVariable Long id) {
    List<ReviewDTO> response = recipeService.getReviewsById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/v1/recipes/{id}/ingredients")
  public ResponseEntity<List<IngredientResponseDTO>> getIngredientsById(@PathVariable Long id) {
    List<IngredientResponseDTO> response = recipeService.getIngredientsById(id);
    return ResponseEntity.ok(response);
  }

}
