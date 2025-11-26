package com.andres.SpringREST_restaurante.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleResponseDTO;
import com.andres.SpringREST_restaurante.services.SaleServiceImpl;

@RestController
@RequestMapping("/api")
public class SaleController {

  private final SaleServiceImpl saleService;

  public SaleController(SaleServiceImpl saleService) {
    this.saleService = saleService;
  }

  @GetMapping("/v1/sales")
  public ResponseEntity<List<SaleResponseDTO>> getAll() {
    List<SaleResponseDTO> response = saleService.getAll();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/v1/sales/{id}")
  public ResponseEntity<SaleResponseDTO> getById(@PathVariable Long id) {
    SaleResponseDTO response = saleService.getById(id);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/v1/sales/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    saleService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/v1/sales")
  public ResponseEntity<SaleResponseDTO> create(@RequestBody SaleRequestDTO req) {
    SaleResponseDTO response = saleService.create(req);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v1/sales/{id}")
  public ResponseEntity<SaleResponseDTO> pay(@PathVariable Long id) {
    SaleResponseDTO response = saleService.paySale(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v1/sales/{saleId}/recipes/{recipeId}")
  public ResponseEntity<RecipeResponseDTO> addRecipe(@PathVariable Long saleId, @PathVariable Long recipeId) {
    RecipeResponseDTO response = saleService.addRecipeById(saleId, recipeId);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/v1/sales/{saleId}/recipes/{recipeId}")
  public ResponseEntity<Void> deleteRecipe(@PathVariable Long saleId, @PathVariable Long recipeId) {
    saleService.removeRecipeById(saleId, recipeId);
    return ResponseEntity.noContent().build();
  }

}
