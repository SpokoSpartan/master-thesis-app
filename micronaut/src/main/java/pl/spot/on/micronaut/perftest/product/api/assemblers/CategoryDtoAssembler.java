package pl.spot.on.micronaut.perftest.product.api.assemblers;

import pl.spot.on.micronaut.perftest.product.Category;
import pl.spot.on.micronaut.perftest.product.api.CategoryDto;

import javax.inject.Singleton;

@Singleton
public class CategoryDtoAssembler {
    public CategoryDto toDto(Category category){
        return new CategoryDto(category.getCode(),category.getName());
    }
}
