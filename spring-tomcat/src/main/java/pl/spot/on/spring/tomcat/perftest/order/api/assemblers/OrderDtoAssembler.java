package pl.spot.on.spring.tomcat.perftest.order.api.assemblers;

import pl.spot.on.spring.tomcat.perftest.order.Order;
import pl.spot.on.spring.tomcat.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderDtoAssembler {
    private final OrderLineDtoAssembler orderLineDtoAssembler;

    public OrderDto toDto(Order order){
        return new OrderDto(
            order.getId(),
            order.getCustomer().getName(),
            order.getStatus().toString(),
            order.getLines().stream().map(orderLineDtoAssembler::toDto).collect(Collectors.toList())
        );
    }
}
