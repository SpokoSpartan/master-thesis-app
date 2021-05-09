package pl.spot.on.micronaut.perftest.product;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class CategoryRepository {
    private final EntityManager em;

    public CategoryRepository(@CurrentSession EntityManager em) {
        this.em = em;
    }

    public void save(Category category){
        em.persist(category);
    }

    public Category findByCode(String code){
        return em.createQuery("from Category c where c.code = :code", Category.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    public List<Category> findAll() {
        return em.createQuery("from Category c", Category.class)
                .getResultList();
    }
}
