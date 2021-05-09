package pl.spot.on.jakarta.perftest.product;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.CreateProductCommand;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;
import pl.spot.on.jakarta.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class CreateProductHandler {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(CreateProductCommand cmd) {
        Category cat = categoryRepository.findByCode(cmd.getCategoryCode());
        Product p = new Product(
                cmd.getCode(),
                cmd.getName(),
                cat,
                cmd.getPrice()
        );
        productRepository.save(p);
        return productDtoAssembler.toDto(p);
    }
}
