package com.training.service;

import java.util.List;

import com.training.domain.Product;

public interface ProductService {
	
	public String addNewProduct(Product toBeAdded);
	public void removeExisting(String id);
	
	public Product findById(String id);
	public List<Product> findAll();
	List<Product> findByQohGreaterThan(int qoh);
	List<Product> findByPriceLessThan(float price);
	List<Product> findByName(String name);

}
