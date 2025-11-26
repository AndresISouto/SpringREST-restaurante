package com.andres.SpringREST_restaurante.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.SpringREST_restaurante.Enums.Unit;
import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.repositories.RecipeRepository;

@Service
@Transactional
public class PrecioService implements IPrecioService {

  private final RecipeRepository recipeRepository;

  public PrecioService(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  public void setPriceWithIngredient(Long id) {
    List<Recipe> recipes = recipeRepository.findByIngredientId(id);
    if (recipes.isEmpty()) {
      throw new NoSuchElementException("no recipe with that ingredient");
    }

    for (Recipe recipe : recipes) {
      setPriceByRecipe(recipe);
    }

  }

  public void setPriceById(Long id) {
    Recipe recipe = recipeRepository.findByIdWithIngredients(id)
        .orElseThrow(() -> new NoSuchElementException("Recipe not found"));

    Double price = 0.0;

    for (Recipe_Ingredient ri : recipe.getIngredients()) {
      Ingredient ingredient = ri.getIngredient();

      // price += ri.getAmount() * ingredient.getInventory().getAmount();
      price += Unit.convert(ri.getUnit(), ri.getAmount())
          * Unit.convert(ingredient.getInventory().getUnit(), ingredient.getInventory().getAmount());
    }
    recipe.setPrecioCoste(price);
    recipe.setPrecioVenta(price * 1.3);

    recipeRepository.save(recipe);

  }

  public void setPriceByRecipe(Recipe recipe) {
    Double price = 0.0;

    for (Recipe_Ingredient ri : recipe.getIngredients()) {
      Ingredient ingredient = ri.getIngredient();

      // price += ri.getAmount() * ingredient.getInventory().getAmount();
      price += Unit.convert(ri.getUnit(), ri.getAmount())
          * Unit.convert(ingredient.getInventory().getUnit(), ingredient.getInventory().getAmount());
    }
    recipe.setPrecioCoste(price);
    recipe.setPrecioVenta(price * 1.3);

    recipeRepository.save(recipe);

  }

  public Double calculatePrice(Set<Recipe_Ingredient> ri) {
    Double price = 0.0;

    for (Recipe_Ingredient item : ri) {
      Ingredient ingredient = item.getIngredient();

      // price += item.getAmount() * ingredient.getInventory().getAmount();
      price += Unit.convert(item.getUnit(), item.getAmount())
          * Unit.convert(ingredient.getInventory().getUnit(), ingredient.getInventory().getAmount());
    }
    return price;
  }
}
