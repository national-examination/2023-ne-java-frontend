package net.enjoy.springboot.registrationlogin.service;

import net.enjoy.springboot.registrationlogin.dto.PurchasedDto;
import net.enjoy.springboot.registrationlogin.entity.Purchased;
import net.enjoy.springboot.registrationlogin.entity.Quantity;

import java.util.List;

public interface PurchasedService {
    Purchased savePurchased(PurchasedDto purchasedDto);
    List<Purchased> listPurchased();
}
