package com.sas.SalesAnalysisSystem.service;

import java.util.List;

import com.sas.SalesAnalysisSystem.model.Product;

public interface ProductService {

	Product getProductById(Long productId);

	List<Product> getAllProduct();

	void deleteProduct(long productId);

	Product updateProduct(Product product);

	Product createProduct(Product product);

}
