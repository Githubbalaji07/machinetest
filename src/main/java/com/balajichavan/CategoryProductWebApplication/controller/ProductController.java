package com.balajichavan.CategoryProductWebApplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.balajichavan.CategoryProductWebApplication.exception.ProductNotFoundException;
import com.balajichavan.CategoryProductWebApplication.model.Product;

import com.balajichavan.CategoryProductWebApplication.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	public ResponseEntity<?> getAllProduct(){
		return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@PostMapping("/api/products")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@GetMapping("/api/products/{id}")
	public ResponseEntity<?> getByIdProduct(@PathVariable Integer id) {
	    
		Optional<Product> product = productService.getProductById(id);
	    if(product.isPresent())
	        return new ResponseEntity<>(product.get(), HttpStatus.OK);
	    else
	    	return new ResponseEntity<>(new ProductNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND); // Returning custom error message
	}

	@DeleteMapping("/api/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
	   
	        if(productService.deleteProduct(id)) {  // Throws exception if not found
	        String msg = "Product Deleted Successfully With Id: " + id;
	        return new ResponseEntity<>(msg, HttpStatus.OK);
	        }
	        else {
	        return new ResponseEntity<>(new ProductNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND); // Returning custom error message
	    }
	}

	@PutMapping("/api/products/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody Product newProduct) {
	   
	        Optional<Product> optional = productService.getProductById(id);  // Throws exception if not found
	      if(optional.isPresent()) { 
	        Product existingProduct=optional.get();
	        	existingProduct.setName(newProduct.getName());
		        existingProduct.setPrice(newProduct.getPrice());
		        existingProduct.setQuantity(newProduct.getQuantity());
		        existingProduct.setCategory(newProduct.getCategory());      
	        return new ResponseEntity<>(productService.saveProduct(existingProduct), HttpStatus.OK);
	    } else{
	        return new ResponseEntity<>(new ProductNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND); // Returning custom error message
	    }
	}

}
