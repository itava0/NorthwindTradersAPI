package org.pluralsight.dao;

import org.pluralsight.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private final DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void add(Product product) {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO products (productName, categoryId, unitPrice) VALUES (?, ?, ?)")) {

            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryId());
            statement.setDouble(3, product.getUnitPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from products;")){
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                products.add(new Product(results.getInt("ProductID"), results.getString("ProductName"), results.getInt("CategoryID"), results.getDouble("UnitPrice")));
                }
            }
        }
        catch (SQLException e){
            System.out.println("An error has occurred in the search");
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products WHERE ProductID = ?")){
            statement.setInt(1, id);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    product = new Product(results.getInt("ProductID"), results.getString("ProductName"), results.getInt("CategoryID"), results.getDouble("UnitPrice"));
                }
            }
        }
        catch (SQLException e){
            System.out.println("An error has occurred in the search");
        }
        return product;
    }

}
