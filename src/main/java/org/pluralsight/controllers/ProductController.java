package org.pluralsight.controllers;

import org.pluralsight.dao.ProductDao;
import org.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    //http://localhost:8080/products
    //http://localhost:8080/products/5

    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }


    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getProducts(){
        List<Product> products = productDao.getAll();
        return products;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        return productDao.getProductById(id);
    }


    @RequestMapping(path="/products", method= RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        productDao.add(product);
    }

    @RequestMapping(path="/products/{id}", method= RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.update(product, id);
    }

    @RequestMapping(path="/products/{id}", method= RequestMethod.DELETE)
    public void updateProduct(@PathVariable int id) {
        productDao.delete(id);
    }

}
