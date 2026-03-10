package com.piacart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piacart.entity.Category;
import com.piacart.entity.Product;

public interface CategoryRepo extends JpaRepository<Category,Long> {
	List<Product> findByCategoryId(Long categoryId);
	List<Category> findByCatenameContainingIgnoreCase(String name);
	List<Category> findByStatus(boolean status);

     //admin sectin
	
	
 

}
