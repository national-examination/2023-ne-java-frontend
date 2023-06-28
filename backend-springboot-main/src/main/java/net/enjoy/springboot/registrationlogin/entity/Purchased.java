package net.enjoy.springboot.registrationlogin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Purchased")
public class Purchased {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code", referencedColumnName = "code", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quantity_id", referencedColumnName = "id", nullable = false)
    private Quantity quantity;

    @Column(nullable = false)
    private String total;

    @Column(nullable = false)
    private Date date;

    @PrePersist
    private void calculateTotal() {
        BigDecimal price = new BigDecimal(product.getPrice());
        BigDecimal quantityValue = new BigDecimal(quantity.getQuantity());
        BigDecimal calculatedTotal = price.multiply(quantityValue);
        this.total = calculatedTotal.toString();
        this.date = new Date();
    }
}