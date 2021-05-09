package pl.spot.on.spring.netty.perftest.product;

import pl.spot.on.spring.netty.perftest.product.api.ProductDto;
import pl.spot.on.spring.netty.perftest.product.api.assemblers.ProductDtoAssembler;
import pl.spot.on.spring.netty.perftest.product.api.ChangeProductCategoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
