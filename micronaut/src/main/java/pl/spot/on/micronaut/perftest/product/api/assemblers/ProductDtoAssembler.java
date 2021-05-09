package pl.spot.on.micronaut.perftest.product.api.assemblers;

import pl.spot.on.micronaut.perftest.product.Product;
import pl.spot.on.micronaut.perftest.product.api.ProductDto;

import javax.inject.Singleton;

@Singleton
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
