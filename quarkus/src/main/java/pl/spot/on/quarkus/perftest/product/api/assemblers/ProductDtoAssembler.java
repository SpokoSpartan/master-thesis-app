package pl.spot.on.quarkus.perftest.product.api.assemblers;

import pl.spot.on.quarkus.perftest.product.api.ProductDto;
import pl.spot.on.quarkus.perftest.product.Product;

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
