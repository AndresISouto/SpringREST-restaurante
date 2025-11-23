package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;

@Service
public interface IproviderService {

  ProviderResponseDTO getById(Long id);

  List<ProviderResponseDTO> getAll();

  Provider getEntityById(Long id);

  ProviderResponseDTO create(ProviderDTO dto);

  ProviderResponseDTO update(ProviderResponseDTO dto);

  void deleteById(Long id);
}
