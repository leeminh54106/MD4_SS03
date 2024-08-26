package com.ra.session03.controller;

import com.ra.session03.model.dto.DataResponse;
import com.ra.session03.model.entity.Category;
import com.ra.session03.service.ICateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICateService cateService;
    @GetMapping
    public ResponseEntity<DataResponse> getAllCategories() {
        return new ResponseEntity<>(new DataResponse(cateService.getCategories(), HttpStatus.OK), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataResponse> getCategoryById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new DataResponse(cateService.getCategoryById(id), HttpStatus.OK), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DataResponse> addCategory(@RequestBody Category category) {
        Category c =cateService.saveCategory(category);
        return new ResponseEntity<>(new DataResponse(c, HttpStatus.CREATED), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DataResponse> updateCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
       category.setId(id);
        Category c = cateService.saveCategory(category);
       return new ResponseEntity<>(new DataResponse(c, HttpStatus.OK), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        cateService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
