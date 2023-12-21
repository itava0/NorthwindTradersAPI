package org.pluralsight.dao;

import org.pluralsight.models.Category;

import java.util.List;

public interface CategoryDao {
    void add(Category category);
    List<Category> getAll();
    Category getCategoryBYId(int id);
}
