package pl.spot.on.quarkus.perftest.order;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findById(Long id){
        return em.find(Order.class, id);
    }
}
