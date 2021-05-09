package pl.spot.on.micronaut.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.customer.api.CreateCustomerCommand;
import pl.spot.on.micronaut.perftest.customer.api.CustomerDto;
import pl.spot.on.micronaut.perftest.customer.api.assembler.CustomerDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
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
