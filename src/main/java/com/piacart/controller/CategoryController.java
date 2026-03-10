package com.piacart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piacart.entity.Category;
import com.piacart.entity.Product;
import com.piacart.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	// user api 
	
	/*
	1.get all category*/
	
	@GetMapping("/getall")
	public List<Category> allcate(){
		return cs.getallcatgory();
	}
	
	/*
	     2. get products by id*/
	@GetMapping("/by/{id}")
	public Optional<Category> catebyid(@PathVariable Long id){
	return	cs.getcategorybyid(id);
	}
	
	/*
	 3.get all product by category id */
	@GetMapping("/{id}/products")
	  public List<Product> pbci(@PathVariable long id){
		  return cs.gpbci(id);
	  }
	 
	  /*
	   4. search category by name*/
	@GetMapping("/search/{name}")
	 public List<Category> nameofcate(@PathVariable String name){
		 return cs.categorybyhisname(name);
	 }
	 
	 /*
	  5. find by status */
	@GetMapping("/status/{status}")
		public List<Category> bystatus(@PathVariable boolean status){
			return cs.findbystatus(status);
		}
		
		//----------====================ADMIN SECTION==================---------------------------//
		
		 /*p
		   1. Add Category*/
	  @PostMapping("/add")
		public Category catadd(@RequestBody Category cat) {
			 return cs.addcat(cat);
			}
		
		 /*
          2. Update Category*/
	  @PutMapping("/update")
		public Category catupdate(@RequestBody Category cat) {
		    return cs.updatecat(cat);
		}	
		
		 /*
		   3.Delete Category*/
	  @DeleteMapping("/delete/{id}")
		public String catdltbyid(@PathVariable Long id) {
			cs.deleteCateById(id);
			return"Category Deleted Successfully";
		}
		/*
		 4.Get All Categories */
	  @GetMapping("/get/all")
		public List<Category> getallcate() {
		    return cs.getallcategory();
		}
		/*
		 5.Get  Categories by id*/
	  @GetMapping("/get/{id}")
	  public Category idtocat(@PathVariable Long id){
	      return cs.catbyid(id);
	  }
		
		
		/*
		 6..Activate category */
	  @PutMapping("/activate/{id}")
	  public Category activatecategory(@PathVariable Long id){
	      return cs.Cateactive(id);
	  }
		
		
		
		/*
		 7..deactivate category */
	  @PutMapping("/deactivate/{id}")
	  public Category deactivatecategory(@PathVariable Long id){
	      return cs.Catedeactivate(id);
	  }
}
