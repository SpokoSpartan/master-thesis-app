package pl.spot.on.micronaut.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.customer.api.CustomerDto;
import pl.spot.on.micronaut.perftest.customer.api.GetCustomerQuery;
import pl.spot.on.micronaut.perftest.customer.api.assembler.CustomerDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class GetCustomerHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(GetCustomerQuery query){
        return customerDtoAssembler.toDto(customerRepository.findByName(query.getName()));
    }
}
