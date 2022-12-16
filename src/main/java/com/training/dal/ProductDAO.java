package com.training.dal;

import java.util.List;

import com.training.domain.Product;

public interface ProductDAO {
	
	public Product save(Product toBeSaved);
	public Product findById(String id);
	public List<Product> findAll();
	public void deleteById(String id);
	
	public List<Product> findByName(String name);
	public List<Product> findByPriceLessThan(float price);
	public List<Product> findByQohGreaterThan(int qoh);
}
