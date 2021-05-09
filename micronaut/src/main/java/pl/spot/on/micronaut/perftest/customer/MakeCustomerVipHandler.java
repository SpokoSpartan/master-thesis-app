package pl.spot.on.micronaut.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.customer.api.CustomerDto;
import pl.spot.on.micronaut.perftest.customer.api.MakeCustomerVipCommand;
import pl.spot.on.micronaut.perftest.customer.api.assembler.CustomerDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class MakeCustomerVipHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(MakeCustomerVipCommand cmd){
        Customer c = customerRepository.findByName(cmd.getName());
        c.makeVip();
        return customerDtoAssembler.toDto(c);
    }
}
