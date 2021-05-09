package pl.spot.on.jakarta.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.ChangeProductCategoryCommand;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;
import pl.spot.on.jakarta.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ChangeProductCategoryHandler {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(ChangeProductCategoryCommand cmd) {
        Category cat = categoryRepository.findByCode(cmd.getNewCategoryCode());
        Product p = productRepository.findByCode(cmd.getProductCode());
        p.changeCategory(cat);
        return productDtoAssembler.toDto(p);
    }
}
