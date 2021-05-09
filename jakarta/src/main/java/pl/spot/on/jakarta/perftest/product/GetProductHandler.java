package pl.spot.on.jakarta.perftest.product;


import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.GetProductQuery;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;
import pl.spot.on.jakarta.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class GetProductHandler {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(GetProductQuery query) {
        return productDtoAssembler.toDto(productRepository.findByCode(query.getCode()));
    }
}
