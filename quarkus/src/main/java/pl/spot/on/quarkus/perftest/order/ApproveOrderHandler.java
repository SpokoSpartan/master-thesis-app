package pl.spot.on.quarkus.perftest.order;


import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.api.ApproveOrderCommand;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;
import pl.spot.on.quarkus.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class ApproveOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(ApproveOrderCommand cmd) {
        Order o = orderRepository.findById(cmd.getOrderId());
        o.approve();
        return orderDtoAssembler.toDto(o);
    }
}
