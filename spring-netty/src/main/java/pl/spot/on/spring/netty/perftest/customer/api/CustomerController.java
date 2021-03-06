package pl.spot.on.spring.netty.perftest.customer.api;

import pl.spot.on.spring.netty.perftest.customer.ChangeAddressHandler;
import pl.spot.on.spring.netty.perftest.customer.CreateCustomerHandler;
import pl.spot.on.spring.netty.perftest.customer.GetCustomerHandler;
import pl.spot.on.spring.netty.perftest.customer.MakeCustomerVipHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CreateCustomerHandler createCustomer;
    private final ChangeAddressHandler changeAddress;
    private final MakeCustomerVipHandler makeCustomerVip;
    private final GetCustomerHandler getCustomer;

    @PostMapping
    public CustomerDto create(@RequestBody CreateCustomerCommand cmd){
        return createCustomer.handle(cmd);
    }

    @PostMapping("/changeAddress")
    public CustomerDto changeAddress(@RequestBody ChangeCustomerAddressCommand cmd){
        return changeAddress.handle(cmd);
    }

    @PostMapping("/makeVip")
    public CustomerDto makeVip(@RequestBody MakeCustomerVipCommand cmd){
        return makeCustomerVip.handle(cmd);
    }

    @GetMapping("/{name}")
    public CustomerDto getCustomerByName(@PathVariable("name") String name){
        return getCustomer.handle(new GetCustomerQuery(name));
    }
}
