package pl.spot.on.micronaut.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.order.api.GetOrderQuery;
import pl.spot.on.micronaut.perftest.order.api.OrderDto;
import pl.spot.on.micronaut.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class GetOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(GetOrderQuery query){
        Order o = orderRepository.findById(query.getOrderId());
        return orderDtoAssembler.toDto(o);
    }
}
