package pl.spot.on.micronaut.perftest.product;


import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.product.api.CategoryDto;
import pl.spot.on.micronaut.perftest.product.api.ListCategoriesQuery;
import pl.spot.on.micronaut.perftest.product.api.assemblers.CategoryDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Transactional
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
