package pl.spot.on.jakarta.perftest.customer;


import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.api.ChangeCustomerAddressCommand;
import pl.spot.on.jakarta.perftest.customer.api.CustomerDto;
import pl.spot.on.jakarta.perftest.customer.api.assemblers.CustomerDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class ChangeAddressHandler {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(ChangeCustomerAddressCommand cmd) {
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
