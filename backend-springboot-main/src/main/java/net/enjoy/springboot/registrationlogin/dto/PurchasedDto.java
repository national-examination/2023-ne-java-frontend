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
public class PurchasedDto {

    private Long code;

    @NotEmpty(message = "Product code should not be empty")
    private String productCode;

    @NotEmpty(message = "Product quantity must not be empty")
    private String quantity;

    @NotEmpty(message = "In date must not be empty")
    private Date inDate;

}
