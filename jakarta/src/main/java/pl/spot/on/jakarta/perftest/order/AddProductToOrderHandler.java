package pl.spot.on.jakarta.perftest.order;

import lombok.NoArgsConstructor;
import pl.spot.on.jakarta.perftest.order.api.AddProductToOrderCommand;
import pl.spot.on.jakarta.perftest.order.api.OrderDto;
import pl.spot.on.jakarta.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.jakarta.perftest.product.Product;
import pl.spot.on.jakarta.perftest.product.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
@NoArgsConstructor
public class AddProductToOrderHandler {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private OrderRepository orderRepository;
    @Inject
    private OrderDtoAssembler orderDtoAssembler;

    public OrderDto handle(AddProductToOrderCommand cmd) {
        Product p = productRepository.findByCode(cmd.getProductCode());
        Order o = orderRepository.findById(cmd.getOrderId());
        o.addProduct(p, cmd.getQuantity());
        return orderDtoAssembler.toDto(o);
    }
}
