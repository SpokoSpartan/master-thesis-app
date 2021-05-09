package pl.spot.on.quarkus.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.api.MakeCustomerVipCommand;
import pl.spot.on.quarkus.perftest.customer.api.CustomerDto;
import pl.spot.on.quarkus.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class MakeCustomerVipHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(MakeCustomerVipCommand cmd) {
        Customer c = customerRepository.findByName(cmd.getName());
        c.makeVip();
        return customerDtoAssembler.toDto(c);
    }
}
