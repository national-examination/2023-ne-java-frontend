package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.ProductDto;
import net.enjoy.springboot.registrationlogin.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDto categoryDto);
    List<Product> listProducts();
}
