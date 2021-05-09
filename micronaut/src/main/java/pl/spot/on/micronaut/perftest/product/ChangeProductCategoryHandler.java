package pl.spot.on.micronaut.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.product.api.ChangeProductCategoryCommand;
import pl.spot.on.micronaut.perftest.product.api.ProductDto;
import pl.spot.on.micronaut.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class ChangeProductCategoryHandler {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(ChangeProductCategoryCommand cmd){
        Category cat = categoryRepository.findByCode(cmd.getNewCategoryCode());
        Product p = productRepository.findByCode(cmd.getProductCode());
        p.changeCategory(cat);
        return productDtoAssembler.toDto(p);
    }
}
