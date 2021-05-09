package pl.spot.on.jakarta.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.ListProductsByCategoryQuery;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;
import pl.spot.on.jakarta.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ListProductsByCategoryHandler {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductDtoAssembler productDtoAssembler;

    public List<ProductDto> handle(ListProductsByCategoryQuery query){
        return productRepository
                .findByCategory(query.getCategoryCode())
                .stream()
                .map(productDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
