package pl.spot.on.spring.netty.perftest.customer;


import pl.spot.on.spring.netty.perftest.customer.api.ChangeCustomerAddressCommand;
import pl.spot.on.spring.netty.perftest.customer.api.CustomerDto;
import pl.spot.on.spring.netty.perftest.customer.api.assemblers.CustomerDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
