package pl.spot.on.spring.netty.perftest.product;

import pl.spot.on.spring.netty.perftest.product.api.assemblers.CategoryDtoAssembler;
import pl.spot.on.spring.netty.perftest.product.api.CategoryDto;
import pl.spot.on.spring.netty.perftest.product.api.CreateCategoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
