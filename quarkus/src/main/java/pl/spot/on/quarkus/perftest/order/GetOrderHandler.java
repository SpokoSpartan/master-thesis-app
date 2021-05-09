package pl.spot.on.quarkus.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.api.GetOrderQuery;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;
import pl.spot.on.quarkus.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
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
