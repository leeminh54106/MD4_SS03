package com.ra.session03.repository;

import com.ra.session03.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICateRepo extends JpaRepository<Category,Integer> {

}
