package org.pluralsight.dao;

import org.pluralsight.models.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
     List<Product> getAll();
     Product getProductById(int id);
    void update(Product product, int id);
    void delete(int id);
}
