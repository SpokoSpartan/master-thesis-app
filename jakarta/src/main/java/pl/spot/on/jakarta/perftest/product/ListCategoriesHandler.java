package pl.spot.on.jakarta.perftest.product;


import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.CategoryDto;
import pl.spot.on.jakarta.perftest.product.api.ListCategoriesQuery;
import pl.spot.on.jakarta.perftest.product.api.assemblers.CategoryDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ListCategoriesHandler {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private CategoryDtoAssembler categoryDtoAssembler;

    public List<CategoryDto> handle(ListCategoriesQuery query) {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryDtoAssembler::toDto)
                .collect(Collectors.toList());
    }
}
