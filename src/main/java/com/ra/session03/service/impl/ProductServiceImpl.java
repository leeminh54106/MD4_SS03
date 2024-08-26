package com.ra.session03.service.impl;

import com.ra.session03.model.entity.Product;
import com.ra.session03.repository.IProductRepo;
import com.ra.session03.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepo productRepo;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).orElseThrow(()->new NoSuchElementException("Product not found"));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}
