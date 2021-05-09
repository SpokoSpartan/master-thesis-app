package pl.spot.on.quarkus.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.api.ChangeProductPriceCommand;
import pl.spot.on.quarkus.perftest.product.api.ProductDto;
import pl.spot.on.quarkus.perftest.product.api.assemblers.ProductDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ChangeProductPriceHandler {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(ChangeProductPriceCommand cmd){
        Product p = productRepository.findByCode(cmd.getProductCode());
        p.changePrice(cmd.getNewPrice());
        return productDtoAssembler.toDto(p);
    }
}
