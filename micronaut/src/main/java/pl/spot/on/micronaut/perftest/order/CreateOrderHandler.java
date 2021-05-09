package pl.spot.on.micronaut.perftest.order;


import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.customer.Customer;
import pl.spot.on.micronaut.perftest.customer.CustomerRepository;
import pl.spot.on.micronaut.perftest.order.api.CreateOrderCommand;
import pl.spot.on.micronaut.perftest.order.api.OrderDto;
import pl.spot.on.micronaut.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class CreateOrderHandler {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(CreateOrderCommand cmd){
        Customer c = customerRepository.findByName(cmd.getCustomerName());
        Order o = new Order(c);
        orderRepository.save(o);
        return orderDtoAssembler.toDto(o);
    }
}
