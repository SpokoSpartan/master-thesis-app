package pl.spot.on.quarkus.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.api.ListProductsByCategoryQuery;
import pl.spot.on.quarkus.perftest.product.api.ProductDto;
import pl.spot.on.quarkus.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ListProductsByCategoryHandler {
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public List<ProductDto> handle(ListProductsByCategoryQuery query){
        return productRepository
                .findByCategory(query.getCategoryCode())
                .stream()
                .map(productDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
