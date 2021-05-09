package pl.spot.on.jakarta.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;
import pl.spot.on.jakarta.perftest.order.api.SubmitOrderCommand;
import pl.spot.on.jakarta.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class SubmitOrderHandler {

    @Inject
    private OrderRepository orderRepository;
    @Inject
    private OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(SubmitOrderCommand cmd) {
        Order o = orderRepository.findById(cmd.getOrderId());
        o.sumbit();
        return orderDtoAssembler.toDto(o);
    }
}
