package pl.spot.on.jakarta.perftest.product.api.assemblers;

import pl.spot.on.jakarta.perftest.product.Product;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
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
