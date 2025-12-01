package com.andres.SpringREST_restaurante.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.SpringREST_restaurante.Enums.State;
import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Sale;
import com.andres.SpringREST_restaurante.entities.Sale_Recipe;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeSaleDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.SaleResponseDTO;
import com.andres.SpringREST_restaurante.entities.mappers.RecipeMapper;
import com.andres.SpringREST_restaurante.entities.mappers.SaleDTOMapper;
import com.andres.SpringREST_restaurante.repositories.SaleRepository;

@Service
@Transactional
public class SaleServiceImpl implements IsaleService {

  private final SaleRepository saleRepository;
  private final SaleDTOMapper mapper;
  private final RecipeServiceImpl recipeServiceImpl;
  private final RecipeMapper recipeMapper;

  public SaleServiceImpl(SaleRepository saleRepository, SaleDTOMapper mapper, RecipeServiceImpl recipeServiceImpl,
      RecipeMapper recipeMapper) {
    this.saleRepository = saleRepository;
    this.mapper = mapper;
    this.recipeServiceImpl = recipeServiceImpl;
    this.recipeMapper = recipeMapper;
  }

  @Override
  public List<SaleResponseDTO> getAll() {
    List<Sale> sales = saleRepository.findAll();
    List<SaleResponseDTO> response = mapper.toDto(sales);

    return response;

  }

  @Override
  public SaleResponseDTO getById(Long id) {
    Sale sale = saleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id not found"));
    SaleResponseDTO response = mapper.toDto(sale);

    return response;
  }

  @Override
  public void deleteById(Long id) {
    saleRepository.deleteById(id);
  }

  @Override
  public SaleResponseDTO create(SaleRequestDTO dto) {
    Sale sale = new Sale();
    sale.setState(State.UNPAID);
    sale.setEmmisionDate(LocalDate.now());

    Double price = 0.0;

    for (RecipeSaleDTO item : dto.recipes()) {
      Recipe recipe = recipeServiceImpl.getEntityById(item.recipe_id());
      price += recipe.getPrecioVenta();
      Sale_Recipe sr = new Sale_Recipe(sale, recipe, item.amount());
      sale.addRecipe(sr);
    }

    sale.setPrice(price);

    saleRepository.save(sale);

    SaleResponseDTO response = mapper.toDto(sale);

    return response;
  }

  @Override
  public RecipeResponseDTO addRecipeById(Long saleId, Long recipeId) {
    Sale sale = saleRepository.findById(saleId).orElseThrow(() -> new NoSuchElementException("id does not exist"));
    Recipe recipe = recipeServiceImpl.getEntityById(recipeId);
    Sale_Recipe sr = new Sale_Recipe(sale, recipe, 1);
    sale.addRecipe(sr);
    RecipeResponseDTO response = recipeMapper.toDto(recipe);

    sale.setPrice(calculateAmountBySale(sale));
    saleRepository.save(sale);

    return response;

  }

  @Override
  public void removeRecipeById(Long saleId, Long recipeId) {
    Sale sale = saleRepository.findById(saleId).orElseThrow(() -> new NoSuchElementException("id does not exist"));
    Recipe recipe = recipeServiceImpl.getEntityById(recipeId);
    Sale_Recipe sr = new Sale_Recipe(sale, recipe, 1);
    sale.removeRecipe(sr);

    sale.setPrice(calculateAmountBySale(sale));
    saleRepository.save(sale);

  }

  @Override
  public Double calculateAmount(Long id) {
    Sale sale = saleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id does not exist"));
    Double price = 0.0;

    for (Sale_Recipe item : sale.getRecipes()) {
      Recipe recipe = item.getRecipe();
      price += recipe.getPrecioVenta();
    }
    sale.setPrice(price);

    saleRepository.save(sale);

    return price;
  }

  public Double calculateAmountBySale(Sale sale) {
    Double price = 0.0;

    for (Sale_Recipe item : sale.getRecipes()) {
      Recipe recipe = item.getRecipe();
      price += recipe.getPrecioVenta();
    }
    sale.setPrice(price);

    saleRepository.save(sale);

    return price;
  }

  public SaleResponseDTO paySale(Long id) {
    Sale sale = saleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id not found"));
    sale.setState(State.PAID);
    saleRepository.save(sale);
    SaleResponseDTO response = mapper.toDto(sale);
    return response;
  }
}
