package metube.repositories;

import metube.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class TubeRepository {

    private static final String persistenceUnitName = "metube";
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

    public List<String> getAllTubeTitles() {

        this.entityManager.getTransaction().begin();

        List<String> titles = this.entityManager
                .createQuery("SELECT t.title FROM tubes t", String.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return titles;
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
