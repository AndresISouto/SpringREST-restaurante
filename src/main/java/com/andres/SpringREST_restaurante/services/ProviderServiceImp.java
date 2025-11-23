package com.andres.SpringREST_restaurante.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;
import com.andres.SpringREST_restaurante.entities.mappers.ProviderDTOMapper;
import com.andres.SpringREST_restaurante.repositories.ProviderRepository;

@Service
@Transactional(readOnly = true)
public class ProviderServiceImp implements IproviderService {

  private final ProviderRepository providerRepository;
  private final ProviderDTOMapper mapper;

  public ProviderServiceImp(ProviderRepository providerRepository, ProviderDTOMapper mapper) {
    this.providerRepository = providerRepository;
    this.mapper = mapper;
  }

  @Override
  public ProviderResponseDTO getById(Long id) {
    Provider provider = providerRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("id does not exist"));

    ProviderResponseDTO response = mapper.toDto(provider);

    return response;
  }

  @Override
  public List<ProviderResponseDTO> getAll() {
    List<Provider> providers = providerRepository.findAll();
    List<ProviderResponseDTO> response = providers.stream()
        .map(provider -> mapper.toDto(provider))
        .collect(Collectors.toList());

    return response;
  }

  @Override
  public Provider getEntityById(Long id) {
    Provider provider = providerRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));
    return provider;
  }

  @Override
  public ProviderResponseDTO create(ProviderDTO dto) {
    Provider provider = mapper.toEntity(dto);
    providerRepository.save(provider);
    ProviderResponseDTO response = mapper.toDto(provider);

    return response;
  }

  @Override
  public ProviderResponseDTO update(ProviderResponseDTO dto) {
    Provider provider = mapper.toEntity(dto);
    providerRepository.save(provider);

    return dto;
  }

  @Override
  public void deleteById(Long id) {
    providerRepository.deleteById(id);
  }

}
