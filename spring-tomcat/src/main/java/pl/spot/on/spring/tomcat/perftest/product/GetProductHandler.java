package pl.spot.on.spring.tomcat.perftest.product;


import pl.spot.on.spring.tomcat.perftest.product.api.GetProductQuery;
import pl.spot.on.spring.tomcat.perftest.product.api.ProductDto;
import pl.spot.on.spring.tomcat.perftest.product.api.assemblers.ProductDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetProductHandler {
    private final ProductRepository productRepository;
    private final ProductDtoAssembler productDtoAssembler;

    public ProductDto handle(GetProductQuery query){
        return productDtoAssembler.toDto(productRepository.findByCode(query.getCode()));
    }
}
