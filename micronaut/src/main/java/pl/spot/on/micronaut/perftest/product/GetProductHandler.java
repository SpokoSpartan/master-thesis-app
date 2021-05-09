package pl.spot.on.micronaut.perftest.product;


import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.product.api.GetProductQuery;
import pl.spot.on.micronaut.perftest.product.api.ProductDto;
import pl.spot.on.micronaut.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class GetProductHandler {
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(GetProductQuery query){
        return productDtoAssembler.toDto(productRepository.findByCode(query.getCode()));
    }
}
