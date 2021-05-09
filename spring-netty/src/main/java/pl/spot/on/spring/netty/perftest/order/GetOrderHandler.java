package pl.spot.on.spring.netty.perftest.order;

import pl.spot.on.spring.netty.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.spring.netty.perftest.order.api.GetOrderQuery;
import pl.spot.on.spring.netty.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(GetOrderQuery query){
        Order o = orderRepository.findById(query.getOrderId());
        return orderDtoAssembler.toDto(o);
    }
}
