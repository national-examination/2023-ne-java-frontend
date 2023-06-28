package net.enjoy.springboot.registrationlogin.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.enjoy.springboot.registrationlogin.entity.Product;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDto {
    private Long id;

    @NotEmpty(message = "Product code must not be empty")
    private String productCode;

    @NotEmpty(message = "Quantity must not be empty")
    private String quantity;

    @NotEmpty(message = "Operation must be an array")
    private String operation;

    @NotEmpty(message = "Date is needed!")
    private Date date;
}
