package pl.spot.on.jakarta.perftest.product;

import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.product.api.CategoryDto;
import pl.spot.on.jakarta.perftest.product.api.CreateCategoryCommand;
import pl.spot.on.jakarta.perftest.product.api.assemblers.CategoryDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class CreateCategoryHandler {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private CategoryDtoAssembler categoryDtoAssembler;

    public CategoryDto handle(CreateCategoryCommand cmd) {
        Category c = new Category(cmd.getCode(), cmd.getName());
        categoryRepository.save(c);
        return categoryDtoAssembler.toDto(c);
    }
}
