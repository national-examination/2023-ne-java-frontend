package net.enjoy.springboot.registrationlogin.repository;


import net.enjoy.springboot.registrationlogin.entity.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedRepository extends JpaRepository<Purchased, Integer> {
}
