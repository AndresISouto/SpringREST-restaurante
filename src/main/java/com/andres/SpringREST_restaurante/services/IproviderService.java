package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;

@Service
public interface IproviderService {

  ProviderDTO getById(Long id);

  List<ProviderDTO> getAll();

  Provider getEntityById(Long id);

  ProviderDTO create(ProviderDTO dto);

  ProviderDTO update(ProviderDTO dto);

  void deleteById(Long id);
}
