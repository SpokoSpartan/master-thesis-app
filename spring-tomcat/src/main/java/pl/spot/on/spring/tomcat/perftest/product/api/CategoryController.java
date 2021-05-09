package pl.spot.on.spring.tomcat.perftest.product.api;

import pl.spot.on.spring.tomcat.perftest.product.CreateCategoryHandler;
import pl.spot.on.spring.tomcat.perftest.product.ListCategoriesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CreateCategoryHandler createCategory;
    private final ListCategoriesHandler listCategories;

    @PostMapping
    public CategoryDto create(@RequestBody CreateCategoryCommand cmd){
        return createCategory.handle(cmd);
    }

    @GetMapping("/all")
    public List<CategoryDto> listAll(){
        return listCategories.handle(new ListCategoriesQuery());
    }
}
