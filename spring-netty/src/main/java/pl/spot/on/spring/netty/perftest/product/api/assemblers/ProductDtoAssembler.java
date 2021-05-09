package pl.spot.on.spring.netty.perftest.product.api.assemblers;

import pl.spot.on.spring.netty.perftest.product.api.ProductDto;
import pl.spot.on.spring.netty.perftest.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoAssembler {
    public ProductDto toDto(Product product){
        return new ProductDto(
                product.getCode(),
                product.getName(),
                product.getCategory().getCode(),
                product.getPrice()
        );
    }
}
