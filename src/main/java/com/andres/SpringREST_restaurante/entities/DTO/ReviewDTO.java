package com.andres.SpringREST_restaurante.entities.DTO;

import jakarta.validation.constraints.NotBlank;

public record ReviewDTO(
    @NotBlank String body) {
}
