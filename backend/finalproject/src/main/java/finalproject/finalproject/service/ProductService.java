package finalproject.finalproject.service;

import finalproject.finalproject.model.Product;
import finalproject.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import finalproject.finalproject.model.Product;
import finalproject.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Find products by category
    public List<Product> findProductsByCategory(String categoryname) {
        return productRepository.findByCategory_Categoryname(categoryname);
    }

    // Find products by stock status
    public List<Product> findProductsByStockStatus(String stockstatus) {
        return productRepository.findByStockstatus(stockstatus);
    }

    // Find products by product name
    public List<Product> findProductsByProductName(String productname) {
        return productRepository.findByProductname(productname);
    }

    // Save or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get product by ID
    public Optional<Product> findProductById(int productId) {
        return productRepository.findById(productId);
    }

    // Delete product by ID
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
