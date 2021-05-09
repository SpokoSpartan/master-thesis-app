package pl.spot.on.quarkus.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.api.CreateCustomerCommand;
import pl.spot.on.quarkus.perftest.customer.api.CustomerDto;
import pl.spot.on.quarkus.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class CreateCustomerHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(CreateCustomerCommand cmd){
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
