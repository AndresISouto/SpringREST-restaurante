package com.andres.SpringREST_restaurante.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.SpringREST_restaurante.entities.DTO.IngredientRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;
import com.andres.SpringREST_restaurante.services.IngredientServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class IngredientController {

  private final IngredientServiceImp ingredientService;

  public IngredientController(IngredientServiceImp ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping("/v1/ingredients")
  public ResponseEntity<List<IngredientResponseDTO>> getAll() {
    List<IngredientResponseDTO> response = ingredientService.getAll();
    return ResponseEntity.ok(response);

  }

  @GetMapping("/v1/ingredients/{id}")
  public ResponseEntity<IngredientResponseDTO> getById(@PathVariable Long id) {
    IngredientResponseDTO response = ingredientService.getById(id);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/v1/ingredients/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    ingredientService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/v1/ingredients")
  public ResponseEntity<IngredientResponseDTO> create(@RequestBody @Valid IngredientRequestDTO dto) {
    IngredientResponseDTO response = ingredientService.create(dto);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/v1/ingredients/{id}")
  public ResponseEntity<IngredientResponseDTO> update(@RequestBody @Valid IngredientUpdateDTO dto) {
    IngredientResponseDTO response = ingredientService.update(dto);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/v1/ingredients/{id}/providers")
  public ResponseEntity<Set<ProviderResponseDTO>> getProvidersById(@PathVariable Long id) {
    Set<ProviderResponseDTO> response = ingredientService.getProvidersById(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v1/ingredients/{ingredientId}/providers/{providerId}")
  public ResponseEntity<ProviderResponseDTO> addProvider(@PathVariable Long ingredientId,
      @PathVariable Long providerId) {
    ProviderResponseDTO response = ingredientService.addProvider(ingredientId, providerId);
    return ResponseEntity.ok(response);

  }

  @DeleteMapping("/v1/ingredients/{ingredientId}/providers/{providerId}")
  public ResponseEntity<ProviderResponseDTO> removeProvider(@PathVariable Long ingredientId,
      @PathVariable Long providerId) {
    ingredientService.removeProvider(ingredientId, providerId);
    return ResponseEntity.noContent().build();

  }
}
