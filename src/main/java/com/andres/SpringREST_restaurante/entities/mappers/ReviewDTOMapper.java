package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;

import com.andres.SpringREST_restaurante.entities.Review;
import com.andres.SpringREST_restaurante.entities.DTO.ReviewDTO;

@Mapper(componentModel = "spring")
public interface ReviewDTOMapper {

  ReviewDTO toDto(Review review);

}
