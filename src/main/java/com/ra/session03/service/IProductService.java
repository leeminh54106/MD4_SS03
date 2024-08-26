package com.ra.session03.service;

import com.ra.session03.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProduct(Integer id);

}
