package com.andres.SpringREST_restaurante.entities.mappers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.andres.SpringREST_restaurante.Enums.Unit;
import com.andres.SpringREST_restaurante.entities.Ingredient;
import com.andres.SpringREST_restaurante.entities.Recipe;
import com.andres.SpringREST_restaurante.entities.Recipe_Ingredient;
import com.andres.SpringREST_restaurante.entities.DTO.IngredientResponseDTO;
import com.andres.SpringREST_restaurante.entities.DTO.RecipeResponseDTO;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RecipeMapperTest {

  @Autowired // <--- Standard Spring Injection
  private RecipeMapper mapper;

  @Test
  void shouldMapRecipeToDto_AndFlattenIngredients() {
    // 1. ARRANGE (Prepare the data)

    // Create the Ingredient (The target of the link)
    Ingredient potato = new Ingredient();
    potato.setIngredient_id(1L);
    potato.setName("Potato");

    // Create the Recipe (The parent)
    Recipe recipe = new Recipe();
    recipe.setRecipe_id(100L);
    recipe.setName("Tortilla");
    recipe.setPortions(4);
    recipe.setSteps("Cut, Fry, Eat");
    recipe.setPrecioVenta(15.50);

    // Create the Intermediary Link (Recipe_Ingredient)
    Recipe_Ingredient link = new Recipe_Ingredient();
    link.setRecipe(recipe); // Link back to recipe
    link.setIngredient(potato); // Link to ingredient
    link.setAmount(5);
    link.setUnit(Unit.Kg); // Assuming your Enum is named Unit

    // Add the link to the Recipe's Set
    recipe.setIngredients(Set.of(link));

    // 2. ACT (Run the mapper)
    RecipeResponseDTO result = mapper.toDto(recipe);
    // 3. ASSERT (Verify the results)

    // Check basic Recipe fields
    assertThat(result).isNotNull();
    assertThat(result.name()).isEqualTo("Tortilla");
    assertThat(result.portions()).isEqualTo(4);
    assertThat(result.precioVenta()).isEqualTo(15.50);

    // Check the List conversion (Set -> List)
    assertThat(result.ingredients()).hasSize(1);

    // CRITICAL: Check the "Flattening"
    // (Did it get 'Potato' from the Ingredient table and '5.0' from the Link
    // table?)
    IngredientResponseDTO ingredientDto = result.ingredients().get(0);

    assertThat(ingredientDto.name()).isEqualTo("Potato"); // Comes from Ingredient Entity
    assertThat(ingredientDto.amount()).isEqualTo(5); // Comes from Link Entity
    assertThat(ingredientDto.unit()).isEqualTo(Unit.Kg); // Enum converted to String
  }
}
