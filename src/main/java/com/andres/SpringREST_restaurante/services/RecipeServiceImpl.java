package com.andres.SpringREST_restaurante.services;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.entities.Review;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeIngredientDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeRequestDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeUpdateDTO;
import com.andres.SpringREST_restaurante.entities.DTO.ReviewDTO;
import com.andres.SpringREST_restaurante.entities.mappers.IngredientDTOMapper;
import com.andres.SpringREST_restaurante.entities.mappers.RecipeMapper;
import com.andres.SpringREST_restaurante.entities.mappers.ReviewDTOMapper;
import com.andres.SpringREST_restaurante.repositories.RecipeRepository;

@Service
@Transactional
public class RecipeServiceImpl implements IrecipeService {

  private final RecipeRepository recipeRepository;
  private final RecipeMapper mapper;
  private final IingredientService ingredientService;
  private final IngredientDTOMapper ingredientMapper;
  private final ReviewDTOMapper reviewMapper;
  private final PrecioService precioService;

  public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper mapper, IingredientService ingredientService,
      IngredientDTOMapper ingredientMapper, ReviewDTOMapper reviewMapper, PrecioService precioService) {
    this.recipeRepository = recipeRepository;
    this.mapper = mapper;
    this.ingredientService = ingredientService;
    this.ingredientMapper = ingredientMapper;
    this.reviewMapper = reviewMapper;
    this.precioService = precioService;
  }

  @Override
  public List<RecipeResponseDTO> getAll() {
    List<Recipe> recipes = recipeRepository.findAll();
    List<RecipeResponseDTO> response = recipes.stream()
        .map(recipe -> mapper.toDto(recipe))
        .collect(Collectors.toList());

    return response;

  }

  @Override
  public RecipeResponseDTO getById(Long id) {
    Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id not found"));
    RecipeResponseDTO response = mapper.toDto(recipe);

    return response;
  }

  public Recipe getEntityById(Long id) {
    Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id not found"));

    return recipe;
  }

  @Override
  public void deleteById(Long id) {
    recipeRepository.deleteById(id);
  }

  @Override
  public RecipeResponseDTO create(RecipeRequestDTO dto) {
    Recipe recipe = mapper.toEntity(dto);
    Set<Recipe_Ingredient> recipeIngredients = new HashSet<>();

    for (RecipeIngredientDTO recipeIngredientDTO : dto.ingredients()) {

      Ingredient ingredient = ingredientService.getEntityById(recipeIngredientDTO.ingredient_id());

      if (ingredient.getInventory().getUnit().getCategory() != recipeIngredientDTO.unit().getCategory()) {
        throw new IllegalArgumentException(
            "units need to be of the same category for ingredient with id: " + recipeIngredientDTO.ingredient_id());
      }

      Recipe_Ingredient recipeIngredient = new Recipe_Ingredient(recipe, ingredient, recipeIngredientDTO.amount(),
          recipeIngredientDTO.unit());

      recipeIngredients.add(recipeIngredient);
      recipe.addRecipeIngredient(recipeIngredient);
    }

    Double price = precioService.calculatePrice(recipeIngredients);
    recipe.setPrecioCoste(price);
    recipe.setPrecioVenta(price * 1.3);

    recipeRepository.save(recipe);

    RecipeResponseDTO response = mapper.toDto(recipe);

    return response;
  }

  @Override
  public RecipeResponseDTO update(RecipeUpdateDTO dto) {

    Recipe recipe = mapper.toEntity(dto);

    for (RecipeIngredientDTO recipeIngredientDTO : dto.ingredients()) {

      Ingredient ingredient = ingredientService.getEntityById(recipeIngredientDTO.ingredient_id());

      if (ingredient.getInventory().getUnit().getCategory() != recipeIngredientDTO.unit().getCategory()) {
        throw new IllegalArgumentException("units need to be of the same category");
      }

      Recipe_Ingredient recipeIngredient = new Recipe_Ingredient(recipe, ingredient, recipeIngredientDTO.amount(),
          recipeIngredientDTO.unit());

      recipe.addRecipeIngredient(recipeIngredient);
    }
    Double price = calculatePrice(recipe.getRecipe_id());
    recipe.setPrecioCoste(price);
    recipe.setPrecioVenta(price * 1.3);
    recipeRepository.save(recipe);

    RecipeResponseDTO response = mapper.toDto(recipe);

    return response;

  }

  @Override
  public List<ReviewDTO> getReviewsById(Long id) {
    Recipe recipe = recipeRepository.findByIdWithReviews(id)
        .orElseThrow(() -> new NoSuchElementException("id does not exist"));
    Set<Review> reviews = recipe.getReviews();
    List<ReviewDTO> response = reviews.stream()
        .map(review -> reviewMapper.toDto(review))
        .toList();

    return response;
  }

  public ReviewDTO addReview(Long recipeId, ReviewDTO dto) {
    Review review = reviewMapper.toEntity(dto);
    Recipe recipe = recipeRepository.findById(recipeId)
        .orElseThrow(() -> new NoSuchElementException("no existe receta con ese id"));

    recipe.addReview(review);
    recipeRepository.save(recipe);

    return dto;
  }

  @Override
  public List<IngredientResponseDTO> getIngredientsById(Long id) {
    Recipe recipe = recipeRepository.findByIdWithIngredients(id)
        .orElseThrow(() -> new NoSuchElementException("Recipe not found"));

    List<Ingredient> ingredients = recipe.getIngredients().stream()
        .map(Recipe_Ingredient::getIngredient)
        .toList();

    List<IngredientResponseDTO> response = ingredients.stream()
        .map(ingredient -> ingredientMapper.toDto(ingredient))
        .toList();

    return response;
  }

  public Double calculatePrice(Long id) {
    Recipe recipe = recipeRepository.findByIdWithIngredients(id)
        .orElseThrow(() -> new NoSuchElementException("Recipe not found"));

    Double price = 0.0;

    for (Recipe_Ingredient ri : recipe.getIngredients()) {
      Ingredient ingredient = ri.getIngredient();

      price += ri.getAmount() * ingredient.getInventory().getAmount();
    }
    return price;

  }

}
