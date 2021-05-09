package pl.spot.on.quarkus.perftest.customer.api;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.ChangeAddressHandler;
import pl.spot.on.quarkus.perftest.customer.CreateCustomerHandler;
import pl.spot.on.quarkus.perftest.customer.GetCustomerHandler;
import pl.spot.on.quarkus.perftest.customer.MakeCustomerVipHandler;

import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
@Path("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerHandler createCustomer;
    private final ChangeAddressHandler changeAddress;
    private final MakeCustomerVipHandler makeCustomerVip;
    private final GetCustomerHandler getCustomer;

    @POST
    public CustomerDto create(CreateCustomerCommand cmd){
        return createCustomer.handle(cmd);
    }

    @POST
    @Path("/changeAddress")
    public CustomerDto changeAddress(ChangeCustomerAddressCommand cmd){
        return changeAddress.handle(cmd);
    }

    @POST
    @Path("/makeVip")
    public CustomerDto makeVip(MakeCustomerVipCommand cmd){
        return makeCustomerVip.handle(cmd);
    }

    @GET
    @Path("/{name}")
    public CustomerDto getCustomerByName(@PathParam("name") String name){
        return getCustomer.handle(new GetCustomerQuery(name));
    }
}
