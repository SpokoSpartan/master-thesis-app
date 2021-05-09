package pl.spot.on.spring.tomcat.perftest.product.api.assemblers;

import pl.spot.on.spring.tomcat.perftest.product.Category;
import pl.spot.on.spring.tomcat.perftest.product.api.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoAssembler {
    public CategoryDto toDto(Category category){
        return new CategoryDto(category.getCode(),category.getName());
    }
}
