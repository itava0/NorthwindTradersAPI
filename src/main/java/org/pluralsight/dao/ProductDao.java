package org.pluralsight.dao;

import org.pluralsight.models.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
     List<Product> getAll();
     Product getProductById(int id);
}
