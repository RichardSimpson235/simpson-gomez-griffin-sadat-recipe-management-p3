package com.revature.services;


import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.revature.driver.Application.class)
public class RecipeServiceTest {

    @Autowired
    RecipeService rs;

    @MockBean
    RecipeRepository rp;


    @Test
    void createRecipe() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setUser(user);


        Mockito.when(rp.save(recipe)).thenReturn(new Recipe());

        recipe = rs.createRecipe(recipe);
        Assertions.assertInstanceOf(Recipe.class, recipe);
    }

    @Test
    void deleteRecipe() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setUser(user);

        rs.deleteRecipe(recipe.getRecipe_id());
        Mockito.verify(rp).deleteById(recipe.getRecipe_id());
    }

    @Test
    void getRecipeById() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setUser(user);


        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        Mockito.when(rp.findById(recipe.getRecipe_id())).thenReturn(optionalRecipe);

        Recipe r = rs.getRecipeById(recipe.getRecipe_id());
        Assertions.assertEquals(r.getRecipe_id(), recipe.getRecipe_id());
    }

    @Test
    void getAllRecipes() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setName("Rice buns");
        recipe.setUser(user);


        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        Mockito.when(rp.findAll()).thenReturn(recipeList);
        List<Recipe> recipes = rs.getAll();
        Assertions.assertEquals(recipes.get(0), recipeList.get(0));
    }

    @Test
    void updateRecipe() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();

        recipe.setUser(user);


        Mockito.when(rp.save(recipe)).thenReturn(new Recipe());

        Recipe recipe1 = rs.updateRecipe(recipe);

        Assertions.assertEquals(recipe1.getRecipe_id(), recipe.getRecipe_id());

    }

    @Test
    void searchRecipe() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setName("Rice buns");
        recipe.setUser(user);

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        Mockito.when(rp.findAll()).thenReturn(recipeList);
        List<Recipe> recipes = rs.search("rice");
        Assertions.assertEquals(recipes.get(0).getName(), recipeList.get(0).getName());
    }


}