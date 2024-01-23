package com.bookstore.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.books.entity.Categories;
import com.bookstore.books.service.CategoryService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/1.0/category")
public class CategoryController {


	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCategory(@RequestBody Categories categories, HttpServletResponse response) {
		Categories cat = categoryService.saveCategory(categories);
		String location = "api/1.0/category/"+cat.getName();
		response.addHeader("Location", location);
	}
	
	@GetMapping("/getall")
	public List<Categories> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/id/{id}")
	public Categories getCategoryById(@PathVariable int id) {
		return categoryService.getCategoriesById(id);
	}
	
	@GetMapping("/{name}")
	public Categories getCategoryByName(@PathVariable String name) {
		return categoryService.getCategoriesByName(name);
	}
	
	@PutMapping("/updateById/{id}")
	public Categories updateCategoryById(@PathVariable int id, @RequestBody Categories categories) {
		return categoryService.updateCategory(id, categories);
	}
	
	@PutMapping("/updateCategoryByName/{name}")
	public Categories updateCategoriesByName(@PathVariable String name, @RequestBody Categories categories) {
		return categoryService.updateCategoryByName(name, categories);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		categoryService.deleteCategoryById(id);
		Categories category = categoryService.getCategoriesById(id);
		if(category==null) {
			return "Category Deleted Successfully";
		}else {
			return "Problem occurs during deletion";
		}
	}
	
	@DeleteMapping("/deleteCategoryByName/{name}")
	public String deleteCategoryByName(@PathVariable String name) {
		categoryService.deleteCategoryByName(name);
		Categories categories = categoryService.getCategoriesByName(name);
		if(categories == null) {
			return "Category Deleted Succesfully";
		}else {
			return "Problem Occur during delation";
		}
	}
}
