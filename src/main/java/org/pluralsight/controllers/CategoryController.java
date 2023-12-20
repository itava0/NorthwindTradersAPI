package org.pluralsight.controllers;

import org.pluralsight.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    //http://localhost:8080/categories
    //http://localhost:8080/categories/17

    @RequestMapping(path="/categories", method= RequestMethod.GET)
    public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Electronics"));
        categories.add(new Category(2, "Electronics"));
        categories.add(new Category(3,  "Appliances"));
        categories.add(new Category(4,  "Fitness"));
        categories.add(new Category(5,  "Electronics"));
        categories.add(new Category(6,  "Electronics"));
        categories.add(new Category(7,  "Computers"));
        categories.add(new Category(8,  "Computers"));
        categories.add(new Category(9,  "Computers"));

        return categories;
    }

    @RequestMapping(path="/categories/{id}", method=RequestMethod.GET)
    public Category getProductById(@PathVariable int id){
        List<Category> categories = getCategories();

        // Find the product with the specified ID
        for (Category category : categories) {
            if (category.getCategoryId() == id) {
                return category;
            }
        }
        return null;
    }
}
