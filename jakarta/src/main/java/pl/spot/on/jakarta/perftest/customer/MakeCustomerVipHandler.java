package pl.spot.on.jakarta.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.api.CustomerDto;
import pl.spot.on.jakarta.perftest.customer.api.MakeCustomerVipCommand;
import pl.spot.on.jakarta.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class MakeCustomerVipHandler {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(MakeCustomerVipCommand cmd) {
        Customer c = customerRepository.findByName(cmd.getName());
        c.makeVip();
        return customerDtoAssembler.toDto(c);
    }
}
