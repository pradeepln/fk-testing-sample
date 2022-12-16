package com.training.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.training.domain.Product;


@Repository
public class ProductDAOMongoImpl implements ProductDAO {
	
	@Autowired
	MongoTemplate mt;

	@Override
	public Product save(Product toBeSaved) {
		return mt.save(toBeSaved);
	}

	@Override
	public Product findById(String id) {
		return mt.findById(id, Product.class);
	}

	@Override
	public List<Product> findAll() {
		return mt.findAll(Product.class);
	}

	@Override
	public void deleteById(String id) {
		Query q = new Query().addCriteria(Criteria.where("id").is(id));
		mt.remove(q, Product.class);
	}

	@Override
	public List<Product> findByName(String name) {
		Query q = new Query().addCriteria(Criteria.where("name").is(name));
		return mt.find(q, Product.class);
	}

	@Override
	public List<Product> findByPriceLessThan(float price) {
		Query q = new Query().addCriteria(Criteria.where("price").lt(price));
		return mt.find(q, Product.class);
	}

	@Override
	public List<Product> findByQohGreaterThan(int qoh) {
		Query q = new Query().addCriteria(Criteria.where("qoh").gt(qoh));
		return mt.find(q, Product.class);
	}

	

	
}
