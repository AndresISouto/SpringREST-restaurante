package com.andres.SpringREST_restaurante.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderDTO;
import com.andres.SpringREST_restaurante.entities.mappers.IngredientDTOMapper;
import com.andres.SpringREST_restaurante.entities.mappers.ProviderDTOMapper;
import com.andres.SpringREST_restaurante.repositories.IngredientRepository;

@Service
public class IngredientServiceImp implements IingredientService {

  private final IngredientRepository ingredientRepository;
  private final IngredientDTOMapper mapper;
  private final ProviderDTOMapper providerMapper;
  private final ProviderServiceImp providerServiceImp;

  public IngredientServiceImp(IngredientRepository ingredientRepository, IngredientDTOMapper mapper,
      ProviderDTOMapper providerMapper, ProviderServiceImp providerServiceImp) {
    this.ingredientRepository = ingredientRepository;
    this.mapper = mapper;
    this.providerMapper = providerMapper;
    this.providerServiceImp = providerServiceImp;
  }

  @Override
  public List<IngredientResponseDTO> getAll() {
    List<Ingredient> ingredients = ingredientRepository.findAll();
    List<IngredientResponseDTO> response = ingredients.stream()
        .map(ingredient -> mapper.toDto(ingredient))
        .collect(Collectors.toList());

    return response;
  }

  @Override
  public IngredientResponseDTO getById(Long id) {
    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id not valid"));
    IngredientResponseDTO response = mapper.toDto(ingredient);

    return response;
  }

  @Override
  public void deleteById(Long id) {
    ingredientRepository.deleteById(id);
  }

  @Override
  public IngredientResponseDTO create(IngredientRequestDTO dto) {
    Ingredient ingredient = mapper.toEntity(dto);
    ingredient.setLastUpdate(LocalDate.now());

    ingredientRepository.save(ingredient);

    IngredientResponseDTO response = mapper.toDto(ingredient);

    return response;

  }

  @Override
  public IngredientResponseDTO update(IngredientUpdateDTO dto) {
    Ingredient ingredient = mapper.toEntity(dto);
    ingredient.setLastUpdate(LocalDate.now());

    ingredientRepository.save(ingredient);

    IngredientResponseDTO response = mapper.toDto(ingredient);

    return response;

  }

  @Override
  public Set<ProviderDTO> getProvidersById(Long id) {
    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));

    Set<Provider> providers = ingredient.getProviders();
    Set<ProviderDTO> response = providers.stream()
        .map(provider -> providerMapper.toDto(provider))
        .collect(Collectors.toSet());

    return response;
  }

  @Override
  public ProviderDTO addProvider(Long ingredient_id, Long provider_id) {
    Ingredient ingredient = ingredientRepository.findById(ingredient_id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));

    Provider provider = providerServiceImp.getEntityById(provider_id);
    ingredient.getProviders().add(provider);
    ingredientRepository.save(ingredient);

    ProviderDTO response = providerMapper.toDto(provider);

    return response;

  }

  @Override
  public void removeProvider(Long ingredient_id, Long provider_id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeProvider'");
  }

}
