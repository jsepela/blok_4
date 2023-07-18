package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productRepository.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        productRepository.updateProduct(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productRepository.deleteProduct(id);
    }
}
