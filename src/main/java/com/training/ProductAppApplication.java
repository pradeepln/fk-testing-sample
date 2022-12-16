package com.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.dal.ProductDAO;
import com.training.dal.repositories.ProductRepository;
import com.training.domain.Product;




@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer = 
				SpringApplication.run(ProductAppApplication.class, args);
		
		
		
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
		
//		testRepo(springContainer);
		
//		testCache(springContainer);
	}



	private static void testRepo(ApplicationContext springContainer) {
		ProductRepository repo = springContainer.getBean(ProductRepository.class);
		Product sample = new Product("spring data repo is cool!", 10000, 100);
		//repo.save(sample);
		repo.myCustomNameForQuery(99).forEach(System.out::println);
		System.out.println("----------->>>> Finished Saving <<<<-------------");
	}

}
