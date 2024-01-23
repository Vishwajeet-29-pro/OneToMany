package com.bookstore.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.books.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

	public Categories findByName(String name);

}
