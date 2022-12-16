package com.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.domain.Product;
import com.training.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	

	
	//GET /products ----------> 200 + Json Array
	
	@Operation(tags = {"Search-Operations"}, summary = "Get All Products")
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.findAll();
	}
	
	
	
	@Operation(tags = {"Core-CRUD-Operations","Search-Operations"}, summary = "Get a Product by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Product", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Product.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Product not found", 
	    content = @Content) })
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getProductById(@Parameter(description = "id of Product to be searched") @PathVariable("pid") String id) {
		
		Product p = service.findById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	
	
	
	
	//POST+Json /products ----> 201+location  .OR. 400
	@Operation(tags = {"Core-CRUD-Operations"}, summary = "Add a New Product")
	@PostMapping("/products")
	public ResponseEntity addProduct(@RequestBody Product toBeAdded) {
		try {
			Object id = service.addNewProduct(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/products/"+id));
			return new ResponseEntity(toBeAdded, headers, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			ErrorMessage msg = new ErrorMessage(400, e.getMessage());
			return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(tags = {"Core-CRUD-Operations"}, summary = "Remove an Existing Product")
	@DeleteMapping("/products/{pid}")
	public ResponseEntity removeProduct(@PathVariable("pid") String id) {
		Product existing = service.findById(id);
		if(existing == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		try {
			service.removeExisting(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (IllegalStateException e) {
			return new ResponseEntity(new ErrorMessage(409, e.getMessage()), HttpStatus.CONFLICT);
		}
	}
	
	//GET /products/search/byname?name=zzzzz ----> DAO & SL => findByName
	@Operation(tags = {"Search-Operations"}, summary = "Search for Products by name")
	@GetMapping("/products/search/byname")
	public List<Product> searchByName(@RequestParam("name") String name){
		return service.findByName(name);
	}
	
	//GET /products/search/bypricelt?price=10000 ----> DAO & SL => findByPriceLessThan
	@Operation(tags = {"Search-Operations"}, summary = "Search for Products by price lessa than parameter")
	@GetMapping("/products/search/bypricelt")
	public List<Product> searchByPriceLessThan(@RequestParam("price") float name){
		return service.findByPriceLessThan(name);
	}
	
	//GET /products/search/byqohgt?qoh=16 ----> DAO & SL => findByQohGreaterThan
	@Operation(tags = {"Search-Operations"}, summary = "Search for Products by qoh greater than parameter")
	@GetMapping("/products/search/byqohgt")
	public List<Product> searchByQohGreaterThan(@RequestParam("qoh") int name){
		return service.findByQohGreaterThan(name);
	}
}
