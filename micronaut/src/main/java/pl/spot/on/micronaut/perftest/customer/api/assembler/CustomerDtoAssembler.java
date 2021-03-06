package pl.spot.on.micronaut.perftest.customer.api.assembler;

import pl.spot.on.micronaut.perftest.customer.Customer;
import pl.spot.on.micronaut.perftest.customer.api.CustomerDto;

import javax.inject.Singleton;

@Singleton
public class CustomerDtoAssembler {
    public CustomerDto toDto(Customer customer){
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
