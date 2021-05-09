package pl.spot.on.jakarta.perftest.customer.api;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.ChangeAddressHandler;
import pl.spot.on.jakarta.perftest.customer.CreateCustomerHandler;
import pl.spot.on.jakarta.perftest.customer.GetCustomerHandler;
import pl.spot.on.jakarta.perftest.customer.MakeCustomerVipHandler;

import javax.inject.Inject;
import javax.ws.rs.*;


@Consumes("application/json")
@Produces("application/json")
@Path("/api/customer")
@NoArgsConstructor
public class CustomerController {

    @Inject
    private CreateCustomerHandler createCustomer;
    @Inject
    private ChangeAddressHandler changeAddress;
    @Inject
    private MakeCustomerVipHandler makeCustomerVip;
    @Inject
    private GetCustomerHandler getCustomer;

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
