package com.andres.SpringREST_restaurante.entities.DTO;

public record ReviewRequestDTO(
    String body,
    Long recipe_id) {
}
