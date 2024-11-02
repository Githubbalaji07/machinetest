package com.balajichavan.CategoryProductWebApplication.exception;


public class CategoryNotFoundException extends RuntimeException{
	
	public CategoryNotFoundException(Integer id) {
			super("Category with Id "+id+" Not Found ");
		}
}
