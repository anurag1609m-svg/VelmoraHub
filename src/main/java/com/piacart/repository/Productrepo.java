package com.piacart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piacart.entity.Product;

public interface Productrepo extends JpaRepository<Product, Integer> {

}
