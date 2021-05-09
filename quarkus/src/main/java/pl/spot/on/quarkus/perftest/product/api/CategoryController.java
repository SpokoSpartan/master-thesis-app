package pl.spot.on.quarkus.perftest.product.api;

import pl.spot.on.quarkus.perftest.product.CreateCategoryHandler;
import pl.spot.on.quarkus.perftest.product.ListCategoriesHandler;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


@Consumes("application/json")
@Produces("application/json")
@Path("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CreateCategoryHandler createCategory;
    private final ListCategoriesHandler listCategories;

    @POST
    public CategoryDto create(CreateCategoryCommand cmd){
        return createCategory.handle(cmd);
    }

    @POST
    @Path("/all")
    public List<CategoryDto> listAll(){
        return listCategories.handle(new ListCategoriesQuery());
    }
}
