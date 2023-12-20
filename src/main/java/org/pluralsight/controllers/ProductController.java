package org.pluralsight.controllers;

import org.pluralsight.models.Product;
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

    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 1,999.99));
        products.add(new Product(3, "Headphones", "Electronics", 2,79.99));
        products.add(new Product(4, "Coffee Maker", "Appliances", 3,49.99));
        products.add(new Product(5, "Fitness Tracker", "Fitness", 4,79.99));
        products.add(new Product(6, "Bluetooth Speaker", "Electronics", 5,39.99));
        products.add(new Product(7, "Digital Camera", "Electronics", 6,299.99));
        products.add(new Product(8, "External Hard Drive", "Computers", 7,89.99));
        products.add(new Product(9, "Wireless Mouse", "Computers", 8,19.99));
        products.add(new Product(10, "Gaming Keyboard", "Computers", 9,69.99));

        return products;
    }

    @RequestMapping(path="/products/{id}", method=RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        List<Product> products = getProducts();

        // Find the product with the specified ID
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

}
