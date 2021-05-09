package pl.spot.on.jakarta.perftest.order;


import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.customer.Customer;
import pl.spot.on.jakarta.perftest.customer.CustomerRepository;
import pl.spot.on.jakarta.perftest.order.api.CreateOrderCommand;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;
import pl.spot.on.jakarta.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class CreateOrderHandler {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    private OrderRepository orderRepository;
    @Inject
    private OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(CreateOrderCommand cmd) {
        Customer c = customerRepository.findByName(cmd.getCustomerName());
        Order o = new Order(c);
        orderRepository.save(o);
        return orderDtoAssembler.toDto(o);
    }
}
