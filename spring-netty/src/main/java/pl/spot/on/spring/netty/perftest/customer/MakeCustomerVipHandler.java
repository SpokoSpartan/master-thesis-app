package pl.spot.on.spring.netty.perftest.customer;

import pl.spot.on.spring.netty.perftest.customer.api.CustomerDto;
import pl.spot.on.spring.netty.perftest.customer.api.MakeCustomerVipCommand;
import pl.spot.on.spring.netty.perftest.customer.api.assemblers.CustomerDtoAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeCustomerVipHandler {
    private final CustomerRepository customerRepository;
    private final CustomerDtoAssembler customerDtoAssembler;

    public CustomerDto handle(MakeCustomerVipCommand cmd){
        Customer c = customerRepository.findByName(cmd.getName());
        c.makeVip();
        return customerDtoAssembler.toDto(c);
    }
}
