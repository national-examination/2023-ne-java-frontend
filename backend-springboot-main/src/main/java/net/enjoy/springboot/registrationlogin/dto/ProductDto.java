package net.enjoy.springboot.registrationlogin.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long code;

    @NotEmpty(message = "Product name should not be empty")
    private String name;

    @NotEmpty(message = "Product type must not be empty")
    private String productType;

    @NotEmpty(message = "Product price must be an array")
    private String price;

    @NotEmpty(message = "In date must not be empty!")
    private Date inDate;

}
