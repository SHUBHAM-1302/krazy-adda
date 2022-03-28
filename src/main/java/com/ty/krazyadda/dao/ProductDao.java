package com.ty.krazyadda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.krazyadda.dto.Product;
import com.ty.krazyadda.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public boolean deleteProductById(int id)
	{
		Product product = getProductById(id);
		if(product != null) {
			productRepository.delete(product);
			return true;
		}
		return false;
	}
	
	public Product getProductById(int id)
	{
		Optional<Product> opt = productRepository.findById(id);
		return opt.get();
	}
	
	public List<Product> getProductList()
	{
		return productRepository.findAll();
	}
	
	public Product updateProduct(int id,Product product) {
		Product product1 = getProductById(id);
		if(product1 != null) {
			return productRepository.save(product);
		}
		return null;
		
	}
}
