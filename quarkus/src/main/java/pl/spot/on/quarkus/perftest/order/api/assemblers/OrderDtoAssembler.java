package pl.spot.on.quarkus.perftest.order.api.assemblers;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.Order;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Collectors;

@ApplicationScoped
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
