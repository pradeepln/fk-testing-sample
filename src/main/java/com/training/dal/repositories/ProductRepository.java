package com.training.dal.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.training.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	public List<Product> findByPriceLessThan(float price);
	
	@Query("{'qoh':{'$gt': ?0}}")
	public List<Product> myCustomNameForQuery(int i);

}
