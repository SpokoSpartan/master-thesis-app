package pl.spot.on.quarkus.perftest.customer;


import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class CustomerRepository {
    private final EntityManager em;

    public void save(Customer customer){
        em.persist(customer);
    }

    public Customer findByName(String name){
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.name = :name", Customer.class);
        return query
                .setParameter("name",name)
                .getSingleResult();
    }
}
