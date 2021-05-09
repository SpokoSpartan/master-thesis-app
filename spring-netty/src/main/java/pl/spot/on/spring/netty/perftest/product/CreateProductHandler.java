package pl.spot.on.spring.netty.perftest.product;

import pl.spot.on.spring.netty.perftest.product.api.ProductDto;
import pl.spot.on.spring.netty.perftest.product.api.CreateProductCommand;
import pl.spot.on.spring.netty.perftest.product.api.assemblers.ProductDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
