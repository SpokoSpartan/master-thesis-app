package pl.spot.on.micronaut.perftest.order;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class OrderRepository {

    private EntityManager em;

    public OrderRepository(@CurrentSession EntityManager em) {
        this.em = em;
    }

    public void save(Order order){
        em.persist(order);
    }

    public Order findById(Long id){
        return em.find(Order.class, id);
    }
}
