package com.piacart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piacart.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    List<Category> findByCatenameContainingIgnoreCase(String name);

    List<Category> findByStatus(boolean status);

}
