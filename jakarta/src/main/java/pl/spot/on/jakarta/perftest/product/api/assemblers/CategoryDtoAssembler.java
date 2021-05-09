package pl.spot.on.jakarta.perftest.product.api.assemblers;

import pl.spot.on.jakarta.perftest.product.Category;
import pl.spot.on.jakarta.perftest.product.api.CategoryDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryDtoAssembler {
    public CategoryDto toDto(Category category){
        return new CategoryDto(category.getCode(),category.getName());
    }
}
