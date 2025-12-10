package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Review;
import com.andres.SpringREST_restaurante.entities.DTO.ReviewDTO;

@Mapper(componentModel = "spring")
public interface ReviewDTOMapper {

  ReviewDTO toDto(Review review);

  @Mapping(target = "recipe", ignore = true)
  @Mapping(target = "review_id", ignore = true)
  Review toEntity(ReviewDTO dto);

}
