package pl.spot.on.jakarta.perftest.order;

import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
@NoArgsConstructor
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findById(Long id){
        return em.find(Order.class, id);
    }
}
