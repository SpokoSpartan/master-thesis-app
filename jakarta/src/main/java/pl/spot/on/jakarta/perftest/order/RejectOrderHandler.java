package pl.spot.on.jakarta.perftest.order;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;
import pl.spot.on.jakarta.perftest.order.api.RejectOrderCommand;
import pl.spot.on.jakarta.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class RejectOrderHandler {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(RejectOrderCommand cmd) {
        Order o = orderRepository.findById(cmd.getOrderId());
        o.reject();
        return orderDtoAssembler.toDto(o);
    }
}
