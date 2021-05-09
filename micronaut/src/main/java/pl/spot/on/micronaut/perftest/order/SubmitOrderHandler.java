package pl.spot.on.micronaut.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.order.api.OrderDto;
import pl.spot.on.micronaut.perftest.order.api.SubmitOrderCommand;
import pl.spot.on.micronaut.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class SubmitOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(SubmitOrderCommand cmd){
        Order o = orderRepository.findById(cmd.getOrderId());
        o.sumbit();
        return orderDtoAssembler.toDto(o);
    }
}
