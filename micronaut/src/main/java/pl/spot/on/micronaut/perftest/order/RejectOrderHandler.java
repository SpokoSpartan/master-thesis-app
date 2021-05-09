package pl.spot.on.micronaut.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.order.api.OrderDto;
import pl.spot.on.micronaut.perftest.order.api.RejectOrderCommand;
import pl.spot.on.micronaut.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class RejectOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(RejectOrderCommand cmd){
        Order o = orderRepository.findById(cmd.getOrderId());
        o.reject();
        return orderDtoAssembler.toDto(o);
    }
}
