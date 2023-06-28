package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.ProductDto;
import net.enjoy.springboot.registrationlogin.dto.PurchasedDto;
import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.entity.Purchased;
import net.enjoy.springboot.registrationlogin.entity.Quantity;
import net.enjoy.springboot.registrationlogin.repository.ProductRepository;
import net.enjoy.springboot.registrationlogin.repository.PurchasedRepository;
import net.enjoy.springboot.registrationlogin.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedServiceImpl implements PurchasedService{
    @Autowired
    private PurchasedRepository purchasedRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private QuantityRepository quantityRepository;

    @Override
    public Purchased savePurchased(PurchasedDto purchasedDto){
        Purchased purchased = new Purchased();
        Product product = productRepository.findById(Long.valueOf(purchasedDto.getProductCode())).orElse(null);

        // Check if the product exists before setting it in the quantity
        if (product != null) {
            purchased.setProduct(product);
        } else {
            throw new IllegalArgumentException("Invalid product code: " + purchasedDto.getProductCode());
        }

        Quantity quantity = quantityRepository.findById(Long.valueOf(purchasedDto.getQuantity())).orElse(null);

        // Check if the product exists before setting it in the quantity
        if (product != null) {
            purchased.setQuantity(quantity);
        } else {
            throw new IllegalArgumentException("Invalid Quantity code: " + purchasedDto.getQuantity());
        }

        purchased.getTotal();
        purchased.setDate(purchasedDto.getInDate());
        Purchased newPurchased = purchasedRepository.save(purchased);
        return newPurchased;
    }

    @Override
    public List<Purchased> listPurchased(){
        return purchasedRepository.findAll();
    }
}
