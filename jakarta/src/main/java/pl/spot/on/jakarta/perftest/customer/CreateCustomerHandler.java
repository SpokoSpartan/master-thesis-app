package pl.spot.on.jakarta.perftest.customer;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.api.CreateCustomerCommand;
import pl.spot.on.jakarta.perftest.customer.api.CustomerDto;
import pl.spot.on.jakarta.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class CreateCustomerHandler {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(CreateCustomerCommand cmd) {
        Customer c = new Customer(
                cmd.getName(),
                new Address(
                        cmd.getCountry(),
                        cmd.getZipCode(),
                        cmd.getCity(),
                        cmd.getStreet()
                ),
                false
        );

        customerRepository.save(c);

        return customerDtoAssembler.toDto(c);
    }
}
