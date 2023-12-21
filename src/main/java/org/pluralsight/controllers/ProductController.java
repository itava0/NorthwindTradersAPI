package org.pluralsight.controllers;

import org.pluralsight.dao.ProductDao;
import org.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
