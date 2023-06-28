package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.ProductDto;
import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setProductType(productDto.getProductType());
        product.setPrice(productDto.getPrice());
        product.setInDate(productDto.getInDate());
        Product newCategory = productRepository.save(product);
        return newCategory;
    }

    @Override
    public List<Product> listProducts(){
        return productRepository.findAll();
    }
}
