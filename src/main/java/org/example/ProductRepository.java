package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(Product updatedProduct) {
        for (Product product : productList) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());
                return;
            }
        }

    }

    public void deleteProduct(long id) {
        productList.removeIf(product -> product.getId() == id);
    }
}