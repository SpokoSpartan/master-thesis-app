package pl.spot.on.spring.netty.perftest.order;


import pl.spot.on.spring.netty.perftest.order.api.ApproveOrderCommand;
import pl.spot.on.spring.netty.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.spring.netty.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApproveOrderHandler {
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(ApproveOrderCommand cmd){
        Order o = orderRepository.findById(cmd.getOrderId());
        o.approve();
        return orderDtoAssembler.toDto(o);
    }
}
