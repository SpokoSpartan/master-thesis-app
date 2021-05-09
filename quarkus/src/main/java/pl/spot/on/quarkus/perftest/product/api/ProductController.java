package pl.spot.on.quarkus.perftest.product.api;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.product.*;

import javax.ws.rs.*;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/api/product/")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductHandler createProduct;
    private final ChangeProductPriceHandler changeProductPrice;
    private final ChangeProductCategoryHandler changeProductCategory;
    private final GetProductHandler getProduct;
    private final ListProductsByCategoryHandler listProductsByCategory;

    @POST
    public ProductDto create(CreateProductCommand cmd) {
        return createProduct.handle(cmd);
    }

    @POST
    @Path("changePrice")
    public ProductDto changePrice(ChangeProductPriceCommand cmd) {
        return changeProductPrice.handle(cmd);
    }

    @POST
    @Path("changeCategory")
    public ProductDto changeCategory(ChangeProductCategoryCommand cmd) {
        return changeProductCategory.handle(cmd);
    }

    @GET
    @Path("{code}")
    public ProductDto getProduct(@PathParam("code") String code) {
        return getProduct.handle(new GetProductQuery(code));
    }

    @GET
    @Path("/byCategory/{category}")
    public List<ProductDto> getByCategory(@PathParam("category") String category) {
        return listProductsByCategory.handle(new ListProductsByCategoryQuery(category));
    }
}
