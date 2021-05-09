package pl.spot.on.jakarta.perftest.order.api;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.order.*;

import javax.inject.Inject;
import javax.ws.rs.*;


@Consumes("application/json")
@Produces("application/json")
@Path("/api/order/")
@NoArgsConstructor
public class OrderController {

    @Inject
    private CreateOrderHandler createOrder;
    @Inject
    private AddProductToOrderHandler addProductToOrder;
    @Inject
    private SubmitOrderHandler submitOrder;
    @Inject
    private ApproveOrderHandler approveOrder;
    @Inject
    private RejectOrderHandler rejectOrder;
    @Inject
    private GetOrderHandler getOrder;

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
