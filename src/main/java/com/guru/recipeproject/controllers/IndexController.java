package com.guru.recipeproject.controllers;

import com.guru.recipeproject.domain.Recipe;
import com.guru.recipeproject.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class IndexController {
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        Set<Recipe> recipes = this.recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "index";
    }
}
