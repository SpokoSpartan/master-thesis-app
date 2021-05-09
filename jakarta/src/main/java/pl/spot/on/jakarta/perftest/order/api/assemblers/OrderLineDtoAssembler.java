package pl.spot.on.jakarta.perftest.order.api.assemblers;

import pl.spot.on.jakarta.perftest.order.OrderLine;
import pl.spot.on.jakarta.perftest.order.api.OrderLineDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
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
