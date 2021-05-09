package pl.spot.on.spring.netty.perftest.product;


import pl.spot.on.spring.netty.perftest.product.api.assemblers.CategoryDtoAssembler;
import pl.spot.on.spring.netty.perftest.product.api.CategoryDto;
import pl.spot.on.spring.netty.perftest.product.api.ListCategoriesQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ListCategoriesHandler {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoAssembler categoryDtoAssembler;

    public List<CategoryDto> handle(ListCategoriesQuery query){
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
