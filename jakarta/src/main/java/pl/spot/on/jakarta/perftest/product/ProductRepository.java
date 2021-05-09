package pl.spot.on.jakarta.perftest.product;

import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Product product) {
        em.persist(product);
    }

    public Product findByCode(String code) {
        return em.createQuery("from Product p where p.code=:code", Product.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    public List<Product> findByCategory(String categoryCode) {
        return em.createQuery("from Product p where p.category.code=:code", Product.class)
                .setParameter("code", categoryCode)
                .getResultList();
    }
}
