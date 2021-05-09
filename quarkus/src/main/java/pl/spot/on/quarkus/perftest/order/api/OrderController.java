package pl.spot.on.quarkus.perftest.order.api;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.*;

import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
@Path("/api/order/")
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrderHandler createOrder;
    private final AddProductToOrderHandler addProductToOrder;
    private final SubmitOrderHandler submitOrder;
    private final ApproveOrderHandler approveOrder;
    private final RejectOrderHandler rejectOrder;
    private final GetOrderHandler getOrder;

    @POST
    public OrderDto create(CreateOrderCommand cmd) {
        return createOrder.handle(cmd);
    }

    @POST
    @Path("addProduct")
    public OrderDto addProduct(AddProductToOrderCommand cmd) {
        return addProductToOrder.handle(cmd);
    }

    @POST
    @Path("submit")
    public OrderDto submit(SubmitOrderCommand cmd) {
        return submitOrder.handle(cmd);
    }

    @POST
    @Path("approve")
    public OrderDto approve(ApproveOrderCommand cmd) {
        return approveOrder.handle(cmd);
    }

    @POST
    @Path("reject")
    public OrderDto reject(RejectOrderCommand cmd) {
        return rejectOrder.handle(cmd);
    }

    @POST
    @Path("{id}")
    public OrderDto getById(@PathParam("id") Long id) {
        return getOrder.handle(new GetOrderQuery(id));
    }
}
