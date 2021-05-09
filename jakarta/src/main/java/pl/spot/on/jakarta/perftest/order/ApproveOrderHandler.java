package pl.spot.on.jakarta.perftest.order;


import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.order.api.ApproveOrderCommand;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;
import pl.spot.on.jakarta.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class ApproveOrderHandler {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(ApproveOrderCommand cmd) {
        Order o = orderRepository.findById(cmd.getOrderId());
        o.approve();
        return orderDtoAssembler.toDto(o);
    }
}
