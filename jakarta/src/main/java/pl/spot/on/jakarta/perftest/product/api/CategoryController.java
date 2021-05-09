package pl.spot.on.jakarta.perftest.product.api;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.product.CreateCategoryHandler;
import pl.spot.on.jakarta.perftest.product.ListCategoriesHandler;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Consumes("application/json")
@Produces("application/json")
@Path("/api/category")
@NoArgsConstructor
public class CategoryController {

    @Inject
    private CreateCategoryHandler createCategory;
    @Inject
    private ListCategoriesHandler listCategories;

    @POST
    public CategoryDto create(CreateCategoryCommand cmd) {
        return createCategory.handle(cmd);
    }

    @POST
    @Path("/all")
    public List<CategoryDto> listAll() {
        return listCategories.handle(new ListCategoriesQuery());
    }
}
