//package com.training.dal;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Repository;
//
//import com.training.domain.Product;
//
//@Repository("alternateDAO")
//public class ProductDAOInMemImpl implements ProductDAO{
//	
//	Map<Integer,Product> db = new ConcurrentHashMap<>();
//	AtomicInteger idSequence = new AtomicInteger(0);
//	
//	
//	@PostConstruct
//	public void seedSomeData() {
//		Product p1 = new Product("phone", 19999, 100);
//		p1.setId(1);
//		Product p2 = new Product("brush", 199, 100);
//		p2.setId(2);
//		db.put(1, p1);
//		db.put(2, p2);
//	}
//	
//	@Override
//	public Product save(Product toBeSaved) {
//		int id = idSequence.incrementAndGet();
//		toBeSaved.setId(id);
//		db.put(id, toBeSaved);
//		return toBeSaved;
//	}
//	
//	@Override
//	public Product findById(int id) {
//		
//		return db.get(id);
//	}
//	
//	@Override
//	public List<Product> findAll() {
//		Collection<Product> values = db.values();
//		return new ArrayList<>(values);
//	}
//	
//	@Override
//	public void deleteById(int id) {
//		db.remove(id);
//		
//	}
//
//}
