package com.andres.SpringREST_restaurante.entities.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;

@Mapper(componentModel = "spring")
public interface ProviderDTOMapper {

  @Mapping(target = "provider_id", ignore = true)
  @Mapping(target = "ingredients", ignore = true)
  Provider toEntity(ProviderDTO dto);

  ProviderResponseDTO toDto(Provider provider);

  @Mapping(target = "ingredients", ignore = true)
  Provider toEntity(ProviderResponseDTO dto);

}
