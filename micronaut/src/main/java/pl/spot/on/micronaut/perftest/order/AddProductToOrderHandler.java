package pl.spot.on.micronaut.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.micronaut.perftest.order.api.AddProductToOrderCommand;
import pl.spot.on.micronaut.perftest.order.api.OrderDto;
import pl.spot.on.micronaut.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.micronaut.perftest.product.Product;
import pl.spot.on.micronaut.perftest.product.ProductRepository;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@RequiredArgsConstructor
public class AddProductToOrderHandler {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(AddProductToOrderCommand cmd){
        Product p = productRepository.findByCode(cmd.getProductCode());
        Order o = orderRepository.findById(cmd.getOrderId());
        o.addProduct(p,cmd.getQuantity());
        return orderDtoAssembler.toDto(o);
    }
}
