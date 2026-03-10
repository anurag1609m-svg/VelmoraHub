package com.piacart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piacart.entity.Category;
import com.piacart.entity.Product;
import com.piacart.entity.User;
import com.piacart.repository.CategoryRepo;
@Service
public class CategoryService {

	@Autowired
	CategoryRepo cr;
	
	// get all category 
	
	public List<Category> getallcatgory(){
		 return	 cr.findAll();
	}
	
	//get category by id 
	
	public Optional<Category> getcategorybyid(long id) {
		return cr.findById(id);
	}
	
	//Get Products By Category
	
	public List<Product> gpbci(long id){
	    Category cat = cr.findById(id).orElseThrow();
	    return cat.getProducts();
	}
	
//  search category by name 
	
	public List<Category> categorybyhisname(String name){
		return cr.findByCatenameContainingIgnoreCase(name);
	}
	// find by status
	
	public List<Category> findbystatus(boolean status){
		return cr.findByStatus(status);
	}
	
	
	
	
	// ----------------ADMIN SECTION--------------
	
	/*
	 1.Add Category*/
	
	public Category addcat(Category cat) {
	 return cr.save(cat);
	}
	
	/*
	 2.Update Category*/
	public Category updatecat(Category cat) {
	    return cr.save(cat);
	}	
	
	/*
	 3.Delete Category*/
	public String deleteCateById(Long id) {

        Category cat = cr.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        

        cr.delete(cat);

        return "Category deleted successfully";
    }	
    
	/*
	 4.Get All Categories (Admin View)*/
	public List<Category> getallcategory() {
	    return cr.findAll();
	}
	
	/*
	 5.Get  Categories by id*/
	public Category catbyid(Long id) {
		return cr.findById(id).orElseThrow();
	}
	
	/*
	 6..Activate category */
	public  Category Cateactive(Long id) {
		Category cat = cr.findById(id).orElseThrow();
	  cat.setStatus(true);
	  return cr.save(cat);
	     
	}
	
	/*
	 7..deactivate category */
	public  Category Catedeactivate(Long id) {
		Category cat = cr.findById(id).orElseThrow();
	  cat.setStatus(false);
	  return cr.save(cat);
	     
	}
}
