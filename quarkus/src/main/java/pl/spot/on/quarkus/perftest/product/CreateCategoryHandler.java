package pl.spot.on.quarkus.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.api.CategoryDto;
import pl.spot.on.quarkus.perftest.product.api.CreateCategoryCommand;
import pl.spot.on.quarkus.perftest.product.api.assemblers.CategoryDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
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
