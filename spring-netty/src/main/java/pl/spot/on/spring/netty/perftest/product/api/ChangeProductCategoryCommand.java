package pl.spot.on.spring.netty.perftest.product.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeProductCategoryCommand {
    private String productCode;
    private String newCategoryCode;
}
