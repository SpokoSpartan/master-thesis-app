package pl.spot.on.jakarta.perftest.customer.api.assemblers;

import pl.spot.on.jakarta.perftest.customer.Customer;
import pl.spot.on.jakarta.perftest.customer.api.CustomerDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerDtoAssembler {
    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getName(),
                customer.getIsVip(),
                customer.getAddress().getCountry(),
                customer.getAddress().getZipCode(),
                customer.getAddress().getCity(),
                customer.getAddress().getStreet()
        );
    }
}
