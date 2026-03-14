package com.piacart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piacart.entity.Product;
import com.piacart.repository.Productrepo;

@Service
public class ProductService {

	@Autowired
	private Productrepo pr;
	
	//=====================--------USER SECTION---------=================
	
	/*
	 1. GET ALL PRODUCTS 
	 */

    	 public List<Product> getallp(){
    		 return pr.findAll();
    	 }
    	 
    /*
        2. GET PRODUCTS BY ID
     */	 
      public void productbyid() {
    	  
      }
}
