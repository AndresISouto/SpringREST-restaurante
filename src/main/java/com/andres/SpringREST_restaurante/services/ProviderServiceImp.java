package com.andres.SpringREST_restaurante.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.mappers.ProviderDTOMapper;
import com.andres.SpringREST_restaurante.repositories.ProviderRepository;

@Service
public class ProviderServiceImp implements IproviderService {

  private final ProviderRepository providerRepository;
  private final ProviderDTOMapper mapper;

  public ProviderServiceImp(ProviderRepository providerRepository, ProviderDTOMapper mapper) {
    this.providerRepository = providerRepository;
    this.mapper = mapper;
  }

  @Override
  public ProviderDTO getById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public List<ProviderDTO> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Provider getEntityById(Long id) {
    Provider provider = providerRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));
    return provider;
  }

  @Override
  public ProviderDTO create(ProviderDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public ProviderDTO update(ProviderDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

}
