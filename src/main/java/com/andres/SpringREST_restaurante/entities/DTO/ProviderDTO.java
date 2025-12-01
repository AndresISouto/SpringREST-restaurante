package com.andres.SpringREST_restaurante.entities.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProviderDTO(
    @NotNull @NotBlank String name) {
}
