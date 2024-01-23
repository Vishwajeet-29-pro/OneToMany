package com.bookstore.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.books.entity.Categories;
import com.bookstore.books.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	public Categories saveCategory(Categories categories) {
		return categoryRepository.save(categories);
	}
	
	
	public List<Categories> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Categories getCategoriesById(int id) {
		return categoryRepository.getReferenceById(id);
	}
	
	public Categories getCategoriesByName(String name) {
		return categoryRepository.findByName(name);
	}
	
	public Categories updateCategory(int id, Categories categories) {
		Categories category = categoryRepository.getReferenceById(id);
		if(category==null) {
			throw new RuntimeException("Id Not found "+id);
		}
		category.setName(categories.getName());
		return categoryRepository.save(category);
	}
	
	public Categories updateCategoryByName(String name, Categories categories) {
		Categories category = categoryRepository.findByName(name);
		if(category== null) {
			throw new RuntimeException("Category name not found "+name);
		}
		category.setName(categories.getName());
		return categoryRepository.save(category);
	}
	
	
	public void deleteCategoryById(int id) {
		Categories category = categoryRepository.getReferenceById(id);
		if(category==null) {
			throw new RuntimeException("Id Not found "+id);
		}
		categoryRepository.delete(category);
	}
	
	public void deleteCategoryByName(String name) {
		Categories category = categoryRepository.findByName(name);
		if(category == null) {
			throw new RuntimeException("Name not found "+name);
		}
		categoryRepository.delete(category);
	}
}
