package pl.spot.on.jakarta.perftest.order.api.assemblers;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.order.Order;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.stream.Collectors;

@ApplicationScoped
@NoArgsConstructor
public class OrderDtoAssembler {

    @Inject
    private OrderLineDtoAssembler orderLineDtoAssembler;

    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getCustomer().getName(),
                order.getStatus().toString(),
                order.getLines().stream().map(orderLineDtoAssembler::toDto).collect(Collectors.toList())
        );
    }
}
