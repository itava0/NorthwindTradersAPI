package org.pluralsight.dao;

import org.pluralsight.models.Category;
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
public class JdbcCategoryDao implements CategoryDao{
    private final DataSource dataSource;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Category category) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO categories (categoryID, categoryName) VALUES (?,?)")) {

            statement.setInt(1, category.getCategoryId());
            statement.setString(2,category.getCategoryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from categories;");){
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    categories.add(new Category(results.getInt("CategoryID"), results.getString("CategoryName")));
                }
            }
        }
        catch (SQLException e){
            System.out.println("An error has occurred in the search");
        }
        return categories;
    }

    @Override
    public Category getCategoryBYId(int id) {
        Category category = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from categories where categoryId = ?;");){
            statement.setInt(1, id);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    category = new Category(results.getInt("CategoryID"), results.getString("CategoryName"));
                }
            }
        }
        catch (SQLException e){
            System.out.println("An error has occurred in the search");
        }
        return category;
    }
}
