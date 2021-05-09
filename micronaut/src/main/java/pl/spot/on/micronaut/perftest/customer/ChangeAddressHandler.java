package pl.spot.on.micronaut.perftest.customer;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.customer.api.ChangeCustomerAddressCommand;
import pl.spot.on.micronaut.perftest.customer.api.CustomerDto;
import pl.spot.on.micronaut.perftest.customer.api.assembler.CustomerDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class ChangeAddressHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(ChangeCustomerAddressCommand cmd){
        Customer c = customerRepository.findByName(cmd.getName());
        c.changeAddress(new Address(
                cmd.getCountry(),
                cmd.getZipCode(),
                cmd.getCity(),
                cmd.getStreet()
        ));

        return customerDtoAssembler.toDto(c);
    }
}
