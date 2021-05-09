package pl.spot.on.micronaut.perftest.product;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class ProductRepository {

    private EntityManager em;

    public ProductRepository(@CurrentSession EntityManager em) {
        this.em = em;
    }

    public void save(Product product){
        em.persist(product);
    }

    public Product findByCode(String code){
        return em.createQuery("from Product p where p.code=:code", Product.class)
                .setParameter("code",code)
                .getSingleResult();
    }

    public List<Product> findByCategory(String categoryCode) {
        return em.createQuery("from Product p where p.category.code=:code", Product.class)
                .setParameter("code", categoryCode)
                .getResultList();
    }
}
