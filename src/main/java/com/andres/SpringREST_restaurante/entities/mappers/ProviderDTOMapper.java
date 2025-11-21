package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;

@Mapper(componentModel = "spring")
public interface ProviderDTOMapper {

  Provider toEntity(ProviderDTO dto);

  ProviderDTO toDto(Provider provider);

}
