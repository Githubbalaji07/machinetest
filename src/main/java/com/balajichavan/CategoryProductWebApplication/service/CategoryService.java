package com.balajichavan.CategoryProductWebApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balajichavan.CategoryProductWebApplication.model.Category;
import com.balajichavan.CategoryProductWebApplication.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;
	
	public Category saveCategory(Category category)
	{
		return repo.save(category);
	}
	
	public List<Category>  getAllCategory()
	{
		return repo.findAll();
	}
	
	public Optional<Category> getCategoryById(Integer id) {
		return repo.findById(id);
	}
	
	public boolean deleteCategory(Integer id) {
		
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
