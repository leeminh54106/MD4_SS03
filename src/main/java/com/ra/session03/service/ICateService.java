package com.ra.session03.service;

import com.ra.session03.model.entity.Category;

import java.util.List;

public interface ICateService {
    List<Category> getCategories();
    Category getCategoryById(Integer id);
    Category saveCategory(Category category);
    void deleteCategory(Integer id);

}
