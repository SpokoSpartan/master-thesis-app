package pl.spot.on.quarkus.perftest.product.api.assemblers;

import pl.spot.on.quarkus.perftest.product.api.CategoryDto;
import pl.spot.on.quarkus.perftest.product.Category;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryDtoAssembler {
    public CategoryDto toDto(Category category){
        return new CategoryDto(category.getCode(),category.getName());
    }
}
