package pl.spot.on.micronaut.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.product.api.ChangeProductPriceCommand;
import pl.spot.on.micronaut.perftest.product.api.ProductDto;
import pl.spot.on.micronaut.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class ChangeProductPriceHandler {
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(ChangeProductPriceCommand cmd){
        Product p = productRepository.findByCode(cmd.getProductCode());
        p.changePrice(cmd.getNewPrice());
        return productDtoAssembler.toDto(p);
    }
}
