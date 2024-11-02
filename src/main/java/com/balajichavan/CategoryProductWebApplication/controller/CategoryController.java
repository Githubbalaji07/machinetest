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

import com.balajichavan.CategoryProductWebApplication.exception.CategoryNotFoundException;
import com.balajichavan.CategoryProductWebApplication.model.Category;

import com.balajichavan.CategoryProductWebApplication.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/api/categories")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
		
	}
	
	@PostMapping("/api/categories")
	public ResponseEntity<?> store(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.OK);
		
	}
	
	@GetMapping("/api/categories/{id}")
	public ResponseEntity<?> getByIdCategory(@PathVariable Integer id) {
		
		 Optional<Category> optional = categoryService.getCategoryById(id);
		    if (optional.isPresent()) {
		        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(new CategoryNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND);
		    }

	}
	
	@DeleteMapping("/api/categories/{id}")
	public ResponseEntity<?> deleteByIdCategory(@PathVariable Integer id) {	
		if(categoryService.deleteCategory(id)) {
			String message="Category Deleted with Id: "+id;
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		else{
			 return new ResponseEntity<>(new CategoryNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/api/categories/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Category category) {
		
		Optional<Category> optional= categoryService.getCategoryById(id);
		if(optional.isPresent())
		{
			Category existing=optional.get();
			existing.setName(category.getName());
			return new ResponseEntity<>(categoryService.saveCategory(existing),HttpStatus.OK);
		}
		else {
			 return new ResponseEntity<>(new CategoryNotFoundException(id).getMessage(), HttpStatus.NOT_FOUND);
		}
	
	}
	
	
}
