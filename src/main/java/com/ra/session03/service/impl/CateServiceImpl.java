package com.ra.session03.service.impl;

import com.ra.session03.model.entity.Category;
import com.ra.session03.repository.ICateRepo;
import com.ra.session03.service.ICateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CateServiceImpl implements ICateService {
    private final ICateRepo cateRepo;
    @Override
    public List<Category> getCategories() {
        return cateRepo.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return cateRepo.findById(id).orElseThrow(()->new NoSuchElementException("Cate not found"));
    }

    @Override
    public Category saveCategory(Category category) {
        return cateRepo.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        cateRepo.findById(id).orElseThrow(()->new NoSuchElementException("Cate not found"));
        cateRepo.deleteById(id);
    }
}
