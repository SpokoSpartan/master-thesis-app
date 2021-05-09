package pl.spot.on.quarkus.perftest.customer;


import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.api.CustomerDto;
import pl.spot.on.quarkus.perftest.customer.api.GetCustomerQuery;
import pl.spot.on.quarkus.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class GetCustomerHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(GetCustomerQuery query){
        return customerDtoAssembler.toDto(customerRepository.findByName(query.getName()));
    }
}
