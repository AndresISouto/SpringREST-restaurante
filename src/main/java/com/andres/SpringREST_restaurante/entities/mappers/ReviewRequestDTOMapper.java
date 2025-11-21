package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Review;
import com.andres.SpringREST_restaurante.entities.DTO.ReviewRequestDTO;

@Mapper(componentModel = "sprign")
public interface ReviewRequestDTOMapper {

  @Mapping(target = "recipe", ignore = true)
  Review toEntity(ReviewRequestDTO dto);

}
