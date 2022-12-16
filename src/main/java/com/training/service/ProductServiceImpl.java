package com.training.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.training.dal.ProductDAO;
import com.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	SMSSender sender;

	ProductDAO dao;// = new ProductDAOInMemImpl();
	
	@Value("${my.own.value}")
	String myVal;
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("---------> My Value "+myVal+" <---------");
	}
	
	@Override
	public String addNewProduct(Product toBeAdded) {
		
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			sender.sendMessage("this is to inform that product added");
			Product added = dao.save(toBeAdded);
			return added.getId();
		}else {
			throw new IllegalArgumentException("The monetory value is LT 10000!");
		}
		
		
	}

	@Override
	public void removeExisting(String id) {
		Product p = dao.findById(id);
		if(p != null) {
			if(p.getPrice() * p.getQoh() < 100000) {
				dao.deleteById(id);
			}else {
				throw new IllegalStateException("Value GT 100k. Can't delete!");
			}
		}
	}

	@Override
	public Product findById(String id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<Product> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Product> findByPriceLessThan(float price) {
		return dao.findByPriceLessThan(price);
	}

	@Override
	public List<Product> findByQohGreaterThan(int qoh) {
		return dao.findByQohGreaterThan(qoh);
	}
	
	

}
