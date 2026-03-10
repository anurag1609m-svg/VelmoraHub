package com.piacart.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cateurl;
    private String catename;

    private String disc;

    private Boolean status;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String cateurl, String catename, String disc, Boolean status, List<Product> products) {
		super();
		this.id = id;
		this.cateurl = cateurl;
		this.catename = catename;
		this.disc = disc;
		this.status = status;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCateurl() {
		return cateurl;
	}

	public void setCateurl(String cateurl) {
		this.cateurl = cateurl;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cateurl=" + cateurl + ", catename=" + catename + ", disc=" + disc + ", status="
				+ status + ", products=" + products + "]";
	}

	
	

    
    
}
