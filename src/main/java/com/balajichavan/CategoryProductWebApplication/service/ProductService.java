package com.balajichavan.CategoryProductWebApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balajichavan.CategoryProductWebApplication.model.Product;
import com.balajichavan.CategoryProductWebApplication.repository.ProductRepo;


@Service
public class ProductService  {
	
	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product product)
	{
		return repo.save(product);
	}
	
	public List<Product>  getAllProduct()
	{
		return repo.findAll();
	}
	
	public Optional<Product> getProductById(Integer id)
	{
		return repo.findById(id);
	}
	
	public boolean deleteProduct(Integer id)
	{
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
