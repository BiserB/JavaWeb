package metube.repositories;


import metube.domain.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class TubeRepository {

    private static final String PERSISTENCE_UNIT_NAME = "metube";
    private final EntityManager entityManager;

    public TubeRepository() {

        this.entityManager = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public Tube findById(String id){

        Tube tube = entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.id = :id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();

        return tube;
    }

    public Tube findByName(String name){

        Tube tube = entityManager
                .createQuery("SELECT t from tubes t WHERE t.name = :name", Tube.class)
                .setParameter("name", name)
                .getSingleResult();

        return tube;
    }

    Tube save(Tube tube){

        entityManager.getTransaction().begin();

        entityManager.persist(tube);

        entityManager.getTransaction().commit();

        return null;
    }


}
