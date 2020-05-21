package com.waris.demo.service;

import java.util.List;

import com.waris.demo.model.Product;

public interface ProductService 
{
	Product createProduct(Product product);
	Product updateProduct(Product product);
	List<Product>getAllProduct();
	Product getProductById(long productIdvoid);
	void deleteProduct(long id);
}
