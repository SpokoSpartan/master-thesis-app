package pl.spot.on.quarkus.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;
import pl.spot.on.quarkus.perftest.order.api.RejectOrderCommand;
import pl.spot.on.quarkus.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class RejectOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(RejectOrderCommand cmd) {
        Order o = orderRepository.findById(cmd.getOrderId());
        o.reject();
        return orderDtoAssembler.toDto(o);
    }
}
