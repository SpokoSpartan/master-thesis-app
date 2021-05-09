package pl.spot.on.micronaut.perftest.customer;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Singleton
public class CustomerRepository {
    private EntityManager entityManager;

    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public Customer findByName(String name) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.name = :name", Customer.class);
        return query
                .setParameter("name", name)
                .getSingleResult();
    }
}
