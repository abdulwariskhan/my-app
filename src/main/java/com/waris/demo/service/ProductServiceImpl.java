package com.waris.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waris.demo.exception.ResourceNotFoundException;
import com.waris.demo.model.Product;
import com.waris.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) 
	{
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = this.productRepository.findById(product.getId());
		if(productDb.isPresent())
		{
			Product productUpdate = productDb.get();
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productUpdate.setPrice(product.getPrice());
		    productRepository.save(productUpdate);
		    return productUpdate;
		}
		else {
			throw new ResourceNotFoundException("Record not Found with id :"+product.getId());
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(long productIdvoid) {
		Optional<Product> productDb = this.productRepository.findById(productIdvoid);
		if(productDb.isPresent()) 
		{
			return productDb.get();
		}
		else {
			throw new ResourceNotFoundException("Record not found with Id :"+productIdvoid);
		}
	}

	@Override
	public void deleteProduct(long id) 
	{
		Optional<Product> productDb = this.productRepository.findById(id);
		if(productDb.isPresent()) 
		{
			this.productRepository.delete(productDb.get());
		}
		else {
			throw new ResourceNotFoundException("Record not found with Id :"+id);
		}
	}

}
