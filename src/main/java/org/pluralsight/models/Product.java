package org.pluralsight.models;

import java.util.Objects;

public class Product {
    private int productId;
    private String productName;
    private String category;

    private int categoryId;
    private double unitPrice;

    public Product(int productId, String productName, String category,int categoryId, double unitPrice) {
        this.productId = productId;
        this.productName= productName;
        this.category = category;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getProductId() == product.getProductId() && getCategoryId() == product.getCategoryId() && Double.compare(getUnitPrice(), product.getUnitPrice()) == 0 && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getCategory(), getCategoryId(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", categoryId=" + categoryId +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
