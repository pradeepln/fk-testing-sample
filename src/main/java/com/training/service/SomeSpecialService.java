//package com.training.service;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.training.dal.ProductDAO;
//
//@Service
//public class SomeSpecialService {
//	
//	@Qualifier("alternateDAO")
//	@Autowired
//	ProductDAO dao;
//	
//	@PostConstruct
//	public void logClassName() {
//		System.out.println("--------->>> Inside Special Service, the dao is: "+dao.getClass().getName()+" <<<---------");
//	}
//
//}
