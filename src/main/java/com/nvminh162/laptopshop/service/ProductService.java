package com.nvminh162.laptopshop.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nvminh162.laptopshop.domain.Product;
import com.nvminh162.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveAProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteAProduct(long id) {
        this.productRepository.deleteById(id);
    }
}
