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

import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;
import com.andres.SpringREST_restaurante.services.ProviderServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProviderController {

  private final ProviderServiceImp providerService;

  public ProviderController(ProviderServiceImp providerService) {
    this.providerService = providerService;
  }

  @GetMapping("/v1/providers")
  public ResponseEntity<List<ProviderResponseDTO>> getAll() {
    List<ProviderResponseDTO> response = providerService.getAll();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/v1/providers/{id}")
  public ResponseEntity<ProviderResponseDTO> getById(@PathVariable Long id) {
    ProviderResponseDTO response = providerService.getById(id);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v1/providers")
  public ResponseEntity<ProviderResponseDTO> create(@RequestBody @Valid ProviderDTO dto) {
    ProviderResponseDTO response = providerService.create(dto);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v1/providers/{id}")
  public ResponseEntity<ProviderResponseDTO> update(@RequestBody @Valid ProviderResponseDTO dto) {
    ProviderResponseDTO response = providerService.update(dto);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/v1/providers/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    providerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
