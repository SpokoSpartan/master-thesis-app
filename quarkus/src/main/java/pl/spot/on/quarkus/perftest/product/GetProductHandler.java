package pl.spot.on.quarkus.perftest.product;


import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.api.GetProductQuery;
import pl.spot.on.quarkus.perftest.product.api.ProductDto;
import pl.spot.on.quarkus.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class GetProductHandler {
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(GetProductQuery query){
        return productDtoAssembler.toDto(productRepository.findByCode(query.getCode()));
    }
}
