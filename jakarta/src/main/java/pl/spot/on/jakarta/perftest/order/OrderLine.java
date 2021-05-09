package pl.spot.on.jakarta.perftest.order;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.product.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderLine {
    private String productCode;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal amount;

    public OrderLine(Product product, Integer quantity) {
        this.productCode = product.getCode();
        this.price = product.getPrice();
        this.quantity = quantity;
        this.amount = this.price.multiply(new BigDecimal(this.quantity)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
