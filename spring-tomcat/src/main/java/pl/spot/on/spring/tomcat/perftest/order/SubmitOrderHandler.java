package pl.spot.on.spring.tomcat.perftest.order;

import pl.spot.on.spring.tomcat.perftest.order.api.SubmitOrderCommand;
import pl.spot.on.spring.tomcat.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.spring.tomcat.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
