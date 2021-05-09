package pl.spot.on.micronaut.perftest.order.api.assemblers;

import pl.spot.on.micronaut.perftest.order.OrderLine;
import pl.spot.on.micronaut.perftest.order.api.OrderLineDto;

import javax.inject.Singleton;

@Singleton
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
