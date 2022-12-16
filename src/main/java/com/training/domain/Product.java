package com.training.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	String id;
	String name;
	float price;
	int qoh;
	
	public Product() {
		
	}

	public Product(String name, float price, int qoh) {
		
		this.name = name;
		this.price = price;
		this.qoh = qoh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQoh() {
		return qoh;
	}

	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qoh=" + qoh + "]";
	}
	
	
}
