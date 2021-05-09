package pl.spot.on.jakarta.perftest.product;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

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
