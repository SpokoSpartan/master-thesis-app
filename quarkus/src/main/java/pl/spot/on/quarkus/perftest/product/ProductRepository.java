package pl.spot.on.quarkus.perftest.product;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

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
