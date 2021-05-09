package pl.spot.on.spring.netty.perftest.product;

import pl.spot.on.spring.netty.perftest.product.api.ChangeProductPriceCommand;
import pl.spot.on.spring.netty.perftest.product.api.ProductDto;
import pl.spot.on.spring.netty.perftest.product.api.assemblers.ProductDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
