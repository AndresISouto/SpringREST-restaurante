# SpringREST-restaurante

Esto es una aplicación hecha con Spring boot para poder gestionar el inventario de un restaurante o similar

## Endpoints

### Recipes

GET all recipes

    http://localhost:8080/api/v1/recipes

GET a recipe with certain id

    http://localhost:8080/api/v1/recipes/{id}

DELETE a recipe with certain id

    http://localhost:8080/api/v1/recipes/{id}

POST a new recipe

    http://localhost:8080/api/v1/recipes

    {
      "name": string,
      "portions": integer,
      "steps": string,
      "ingredients":[
        {
         "ingredien_id":long,
         "unit":unit,
         "amount":double
        },
        {

"ingredien_id":long,
"unit":unit,
"amount":double
}
]
}

PUT an updated recipe

    http://localhost:8080/api/v1/recipes/{id}

    {
      "recipe_id": long
      "name": string,
      "portions": integer,
      "steps": string,
      "ingredients":[
        {
         "ingredien_id":long,
         "unit":unit,
         "amount":double
        },
        {
         "ingredien_id":long,
         "unit":unit,
         "amount":double
        }
      ]
    }

GET reviews of a recipe

    http://localhost:8080/api/v1/recipes/{id}/reviews

GET ingredients of a recipe

    http://localhost:8080/api/v1/recipes/{id}/ingredients

### Ingredients

GET all ingredients

    http://localhost:8080/api/v1/ingredients

GET an ingredient with certain id

    http://localhost:8080/api/v1/ingredients/{id}

DELETE an ingredient with certain id

    http://localhost:8080/api/v1/ingredients/{id}

POST create an ingredient

    http://localhost:8080/api/v1/ingredients

    {
     "name":string,
     "amount":double,
     "unit":Unit,
     "pricePerUnit": double
    }

PUT update an ingredient

    http://localhost:8080/api/v1/ingredients/{id}

    {
     "ingredient_id":long,
     "name":string,
     "amount":double,
     "unit":Unit,
     "pricePerUnit": double
    }

GET providers of an ingredient with a certain id

    http://localhost:8080/api/v1/ingredients/{id}/providers

POST add a provider to a certain ingredient

    http://localhost:8080/api/v1/ingredients/{ingredientId}/providers/{providerId}

DELETE remove a provider for a certain ingredient

    http://localhost:8080/api/v1/ingredients/{ingredientId}/providers/{providerId}

### Providers

GET all providers

    http://localhost:8080/api/v1/providers

GET a provider with a certain id

    http://localhost:8080/api/v1/providers/{id}

POST create a provider

    http://localhost:8080/api/v1/providers

    {
      "name":string
    }

PUT update a provider

    http://localhost:8080/api/v1/providers/{id}

    {
      "provider_id":long,
      "name":string
    }

DELETE a provider with a certain id

    http://localhost:8080/api/v1/providers/{id}

### Sales

GET all Sales

    http://localhost:8080/api/v1/sales

GET a sale with a certain id

    http://localhost:8080/api/v1/sales/{id}

DELETE a sale with a certain id

    http://localhost:8080/api/v1/sales/{id}

POST create a sale

    http://localhost:8080/api/v1/sales
    {
     "recipes":[
        {
          "recipe_id":long,
          "amount":integer
        },
        {
          "recipe_id":long,
          "amount":integer
        }
      ]
    }

POST add recipe to sale

    http://localhost:8080/api/v1/sales/{saleId}/recipes/{recipeId}

DELETE recipe from sale

    http://localhost:8080/api/v1/sales/{saleId}/recipes/{recipeId}

POST pay sale

    http://localhost:8080/api/v1/sales/{saleId}
