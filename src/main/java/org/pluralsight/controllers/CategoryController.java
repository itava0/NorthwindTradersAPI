package org.pluralsight.controllers;

import org.pluralsight.dao.CategoryDao;
import org.pluralsight.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @RequestMapping(path="/categories", method= RequestMethod.GET)
    public List<Category> getCategories(){
        List<Category> categories = categoryDao.getAll();

        return categories;
    }

    @RequestMapping(path="/categories/{id}", method=RequestMethod.GET)
    public Category getProductById(@PathVariable int id) {
        return categoryDao.getCategoryBYId(id);
    }
}
