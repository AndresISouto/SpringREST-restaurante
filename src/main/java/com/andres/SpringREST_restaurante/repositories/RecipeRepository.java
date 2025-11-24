package com.andres.SpringREST_restaurante.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andres.SpringREST_restaurante.entities.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  @Query("SELECT r FROM Recipe r " +
      "LEFT JOIN FETCH r.ingredients ri " + // Fetch Recipe_Ingredient
      "LEFT JOIN FETCH ri.ingredient " + // Fetch Ingredient
      "WHERE r.recipe_id = :recipeId")
  Optional<Recipe> findByIdWithIngredients(@Param("recipeId") Long recipeId);

  @Query("SELECT r FROM Recipe r " +
      "LEFT JOIN FETCH r.ingredients ri " + // Fetch Recipe_Ingredient
      "LEFT JOIN FETCH ri.ingredient i " + // Fetch Ingredient
      "WHERE i.ingredient_id = :ingredientId")
  List<Recipe> findByIngredientId(@Param("ingredientId") Long ingredientId);

  @Query("SELECT r FROM Recipe r " +
      "LEFT JOIN FETCH r.reviews rs " +
      "WHERE r.recipe_id = :recipeId")
  Optional<Recipe> findByIdWithReviews(@Param("recipeId") Long recipeId);
}
