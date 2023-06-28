package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.QuantityDto;
import net.enjoy.springboot.registrationlogin.entity.Quantity;

import java.util.List;

public interface QuantityService {
    Quantity saveQuantity(QuantityDto restaurantDto);
    List<Quantity> listQuantities();
}
