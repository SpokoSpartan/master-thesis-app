package pl.spot.on.quarkus.perftest.customer;


import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.api.ChangeCustomerAddressCommand;
import pl.spot.on.quarkus.perftest.customer.api.CustomerDto;
import pl.spot.on.quarkus.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
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
