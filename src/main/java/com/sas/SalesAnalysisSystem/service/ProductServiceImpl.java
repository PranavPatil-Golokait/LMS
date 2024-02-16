package com.sas.SalesAnalysisSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Product;
import com.sas.SalesAnalysisSystem.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = productRepository.findById(product.getId());
        System.out.println(product);
        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            System.out.println(productUpdate);
            productUpdate.setProductName(product.getProductName());
            productUpdate.setImage(product.getImage());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setCategory(product.getCategory());
            productUpdate.setIsActive(product.getIsActive());
            System.out.println(productUpdate);
            return productRepository.save(productUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        return productDb.orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + productId));
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        productDb.ifPresentOrElse(
            product -> productRepository.delete(product),
            () -> {
                throw new ResourceNotFoundException("Record not found with id: " + productId);
            }
        );
    }
}
