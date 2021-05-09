package pl.spot.on.spring.netty.perftest.order.api.assemblers;

import pl.spot.on.spring.netty.perftest.order.api.OrderLineDto;
import pl.spot.on.spring.netty.perftest.order.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineDtoAssembler {
    public OrderLineDto toDto(OrderLine line){
        return new OrderLineDto(
                line.getProductCode(),
                line.getPrice(),
                line.getQuantity(),
                line.getAmount()
        );
    }
}
