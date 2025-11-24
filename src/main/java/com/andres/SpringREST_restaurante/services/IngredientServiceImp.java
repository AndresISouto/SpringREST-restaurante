package com.andres.SpringREST_restaurante.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.Provider;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ProviderResponseDTO;
import com.andres.SpringREST_restaurante.entities.mappers.IngredientDTOMapper;
import com.andres.SpringREST_restaurante.entities.mappers.ProviderDTOMapper;
import com.andres.SpringREST_restaurante.repositories.IngredientRepository;

@Service
@Transactional(readOnly = true)
public class IngredientServiceImp implements IingredientService {

  private final IngredientRepository ingredientRepository;
  private final IngredientDTOMapper mapper;
  private final ProviderDTOMapper providerMapper;
  private final ProviderServiceImp providerServiceImp;
  private final PrecioService precioService;

  public IngredientServiceImp(IngredientRepository ingredientRepository, IngredientDTOMapper mapper,
      ProviderDTOMapper providerMapper, ProviderServiceImp providerServiceImp,
      PrecioService priceService) {
    this.ingredientRepository = ingredientRepository;
    this.mapper = mapper;
    this.providerMapper = providerMapper;
    this.providerServiceImp = providerServiceImp;
    this.precioService = priceService;
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
  @Transactional
  public void deleteById(Long id) {
    ingredientRepository.deleteById(id);
  }

  @Override
  @Transactional
  public IngredientResponseDTO create(IngredientRequestDTO dto) {
    Ingredient ingredient = mapper.toEntity(dto);
    ingredient.setLastUpdate(LocalDate.now());

    ingredientRepository.save(ingredient);

    IngredientResponseDTO response = mapper.toDto(ingredient);

    return response;

  }

  @Override
  @Transactional
  public IngredientResponseDTO update(IngredientUpdateDTO dto) {
    Ingredient ingredient = mapper.toEntity(dto);
    ingredient.setLastUpdate(LocalDate.now());

    ingredientRepository.save(ingredient);

    precioService.setPriceWithIngredient(ingredient.getIngredient_id());

    IngredientResponseDTO response = mapper.toDto(ingredient);

    return response;

  }

  @Override
  public Set<ProviderResponseDTO> getProvidersById(Long id) {
    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));

    Set<Provider> providers = ingredient.getProviders();
    Set<ProviderResponseDTO> response = providers.stream()
        .map(provider -> providerMapper.toDto(provider))
        .collect(Collectors.toSet());

    return response;
  }

  @Override
  @Transactional
  public ProviderResponseDTO addProvider(Long ingredient_id, Long provider_id) {
    Ingredient ingredient = ingredientRepository.findById(ingredient_id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));

    Provider provider = providerServiceImp.getEntityById(provider_id);
    ingredient.addProvider(provider);

    ingredientRepository.save(ingredient);

    ProviderResponseDTO response = providerMapper.toDto(provider);

    return response;

  }

  @Override
  @Transactional
  public void removeProvider(Long ingredient_id, Long provider_id) {
    Ingredient ingredient = ingredientRepository.findById(ingredient_id)
        .orElseThrow(() -> new IllegalArgumentException("id does not exist"));

    Provider provider = providerServiceImp.getEntityById(provider_id);
    ingredient.removeProvider(provider);

    ingredientRepository.save(ingredient);

  }

  @Override
  public Ingredient getEntityById(Long id) {
    Ingredient ingredient = ingredientRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Ingredient id does not exist"));
    return ingredient;
  }

}
