package pl.spot.on.micronaut.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.product.api.CategoryDto;
import pl.spot.on.micronaut.perftest.product.api.CreateCategoryCommand;
import pl.spot.on.micronaut.perftest.product.api.assemblers.CategoryDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class CreateCategoryHandler {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoAssembler categoryDtoAssembler;

    public CategoryDto handle(CreateCategoryCommand cmd){
        Category c = new Category(cmd.getCode(),cmd.getName());
        categoryRepository.save(c);
        return categoryDtoAssembler.toDto(c);
    }
}
