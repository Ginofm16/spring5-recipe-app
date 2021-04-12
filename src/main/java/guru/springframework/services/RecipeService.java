package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

	Set<Recipe> getRecipes();

    Recipe findById(Long l);
    
    RecipeCommand findCommandById(Long l);
    
    /*para guardar la entidad que regresa del nivel web.*/
    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
