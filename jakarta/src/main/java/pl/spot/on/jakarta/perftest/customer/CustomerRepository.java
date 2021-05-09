package pl.spot.on.jakarta.perftest.customer;


import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class CustomerRepository {

    @PersistenceContext
    private EntityManager em;

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
