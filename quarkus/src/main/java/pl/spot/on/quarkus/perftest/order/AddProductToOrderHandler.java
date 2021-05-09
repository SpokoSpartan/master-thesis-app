package pl.spot.on.quarkus.perftest.order;

import lombok.RequiredArgsConstructor;
import pl.spot.on.quarkus.perftest.order.api.AddProductToOrderCommand;
import pl.spot.on.quarkus.perftest.product.Product;
import pl.spot.on.quarkus.perftest.product.ProductRepository;
import pl.spot.on.quarkus.perftest.order.api.OrderDto;
import pl.spot.on.quarkus.perftest.order.api.assemblers.OrderDtoAssembler;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
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
