package net.enjoy.springboot.registrationlogin.controller;

import net.enjoy.springboot.registrationlogin.dto.QuantityDto;
import net.enjoy.springboot.registrationlogin.entity.Quantity;
import net.enjoy.springboot.registrationlogin.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


// Controller for the quantities which are registering a new quantity and getting all quantities available
@RestController
@RequestMapping("/quantity")
public class QuantityController {
    @Autowired
    private QuantityService quantityService;

    @GetMapping("/quantities")
    public List<Quantity> getQuantities() {
        return quantityService.listQuantities();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody QuantityDto quantityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors: " + errorMessages);
        }
        quantityService.saveQuantity(quantityDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully!");
    }
}
