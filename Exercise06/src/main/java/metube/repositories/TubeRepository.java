package metube.repositories;


import metube.domain.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;


public class TubeRepository {

    private static final String PERSISTENCE_UNIT_NAME = "metube";
    private final EntityManager entityManager;

    public TubeRepository(TubeRepository repository) {

        this.entityManager = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public Optional<Tube> findByName(String name){

        Optional<List> result = Optional.of(
                entityManager.createQuery(
                                "SELECT t FROM tubes t"
        ).getResultList());


        return null;
    }

    Tube save(Tube tube){

        entityManager.getTransaction().begin();

        entityManager.persist(tube);

        entityManager.getTransaction().commit();

        return null;
    }

    Tube findById(String id){

        Tube tube = entityManager
                .createQuery("SELECT t FROM tubes t WHERE t.id = :id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();

        return tube;
    }
}
