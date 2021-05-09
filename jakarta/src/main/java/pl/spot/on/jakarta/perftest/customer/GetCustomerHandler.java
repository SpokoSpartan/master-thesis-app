package pl.spot.on.jakarta.perftest.customer;


import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.api.CustomerDto;
import pl.spot.on.jakarta.perftest.customer.api.GetCustomerQuery;
import pl.spot.on.jakarta.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;


@Transactional
@ApplicationScoped
@NoArgsConstructor
public class GetCustomerHandler {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(GetCustomerQuery query) {
        return customerDtoAssembler.toDto(customerRepository.findByName(query.getName()));
    }
}
