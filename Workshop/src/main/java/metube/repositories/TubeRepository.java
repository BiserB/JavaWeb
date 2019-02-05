package metube.repositories;

import metube.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TubeRepository {

    private static final String persistenceUnitName = "workshop";
    private EntityManager entityManager;

    public TubeRepository() {
        this.entityManager = Persistence
                .createEntityManagerFactory(persistenceUnitName)
                .createEntityManager();
    }

    public Tube save(Tube entity) {

        this.entityManager.getTransaction().begin();

        this.entityManager.persist(entity);

        this.entityManager.getTransaction().commit();

        return entity;
    }

    public Tube getById(String id) {

        this.entityManager.getTransaction().begin();

        Tube tube = this.entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.id = :id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return tube;
    }

    public List<Tube> findAll() {

        this.entityManager.getTransaction().begin();

        List<Tube> tubes = this.entityManager
                .createQuery("SELECT t FROM tubes t", Tube.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return tubes;
    }

    public Tube getByTitle(String title) {

        this.entityManager.getTransaction().begin();

        Tube tube = this.entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.title = :title", Tube.class)
                .setParameter("title", title)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return tube;
    }
}
