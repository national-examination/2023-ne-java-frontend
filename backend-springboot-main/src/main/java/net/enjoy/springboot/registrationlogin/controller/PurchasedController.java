package net.enjoy.springboot.registrationlogin.controller;


import net.enjoy.springboot.registrationlogin.dto.ProductDto;
import net.enjoy.springboot.registrationlogin.dto.PurchasedDto;
import net.enjoy.springboot.registrationlogin.entity.Product;
import net.enjoy.springboot.registrationlogin.entity.Purchased;
import net.enjoy.springboot.registrationlogin.service.ProductService;
import net.enjoy.springboot.registrationlogin.service.PurchasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// Controller for the purchased products which are registering a new purchased product and getting all purchased products available
@RestController
@RequestMapping("/purchased")
public class PurchasedController {
    @Autowired
    private PurchasedService purchasedService;

    @GetMapping("/")
    public List<Purchased> getProducts() {
        return purchasedService.listPurchased();
    }

    @PostMapping("/newPurchased")
    public ResponseEntity<String> createProduct(@RequestBody PurchasedDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors: " + errorMessages);
        }
        purchasedService.savePurchased(productDto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Saved successfully!");
    }
}
