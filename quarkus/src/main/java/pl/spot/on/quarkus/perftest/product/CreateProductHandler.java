package pl.spot.on.quarkus.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.api.CreateProductCommand;
import pl.spot.on.quarkus.perftest.product.api.ProductDto;
import pl.spot.on.quarkus.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class CreateProductHandler {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(CreateProductCommand cmd){
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
