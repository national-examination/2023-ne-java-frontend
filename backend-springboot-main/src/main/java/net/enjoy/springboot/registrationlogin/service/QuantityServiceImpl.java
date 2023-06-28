package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.QuantityDto;
import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.entity.Quantity;
import net.enjoy.springboot.registrationlogin.repository.ProductRepository;
import net.enjoy.springboot.registrationlogin.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityServiceImpl implements QuantityService {
    @Autowired
    private QuantityRepository quantityRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Quantity saveQuantity(QuantityDto quantityDto) {
        Quantity quantity = new Quantity();
        Product product = productRepository.findById(Long.valueOf(quantityDto.getProductCode())).orElse(null);

        // Check if the product exists before setting it in the quantity
        if (product != null) {
            quantity.setProduct(product);
        } else {
            throw new IllegalArgumentException("Invalid product code: " + quantityDto.getProductCode());
        }

        quantity.setQuantity(quantityDto.getQuantity());
        quantity.setOperation(quantityDto.getOperation());
        quantity.setDate(quantityDto.getDate());

        Quantity newQuantity = quantityRepository.save(quantity);
        return newQuantity;
    }

    @Override
    public List<Quantity> listQuantities(){
        return quantityRepository.findAll();
    }
}
