package pl.spot.on.jakarta.perftest.product;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.ChangeProductPriceCommand;
import pl.spot.on.jakarta.perftest.product.api.ProductDto;
import pl.spot.on.jakarta.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class ChangeProductPriceHandler {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(ChangeProductPriceCommand cmd) {
        Product p = productRepository.findByCode(cmd.getProductCode());
        p.changePrice(cmd.getNewPrice());
        return productDtoAssembler.toDto(p);
    }
}
