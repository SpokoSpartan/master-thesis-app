package pl.spot.on.spring.netty.perftest.order;

import pl.spot.on.spring.netty.perftest.order.api.AddProductToOrderCommand;
import pl.spot.on.spring.netty.perftest.order.api.assemblers.OrderDtoAssembler;
import pl.spot.on.spring.netty.perftest.product.Product;
import pl.spot.on.spring.netty.perftest.product.ProductRepository;
import pl.spot.on.spring.netty.perftest.order.api.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
