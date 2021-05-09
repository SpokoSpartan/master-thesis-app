package pl.spot.on.quarkus.perftest.order;


import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.customer.Customer;
import pl.spot.on.quarkus.perftest.customer.CustomerRepository;
import pl.spot.on.quarkus.perftest.order.api.CreateOrderCommand;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;
import pl.spot.on.quarkus.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
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
