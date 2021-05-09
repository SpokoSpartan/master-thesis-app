package pl.spot.on.spring.netty.perftest.order;


import pl.spot.on.spring.netty.perftest.customer.Customer;
import pl.spot.on.spring.netty.perftest.customer.CustomerRepository;
import pl.spot.on.spring.netty.perftest.order.api.CreateOrderCommand;
import pl.spot.on.spring.netty.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.spring.netty.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
