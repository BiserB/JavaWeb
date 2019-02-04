package chushka.repositories;

import chushka.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepository {

    private static final String persistenceUnitName = "chushka";
    private EntityManager entityManager;

    public ProductRepository() {

        this.entityManager = Persistence
                .createEntityManagerFactory(persistenceUnitName)
                .createEntityManager();
    }

    public Product save(Product entity) {

        this.entityManager.getTransaction().begin();

        this.entityManager.persist(entity);

        this.entityManager.getTransaction().commit();

        return entity;
    }

    public Product getById(String id) {

        this.entityManager.getTransaction().begin();

        Product product = this.entityManager
                .createQuery("SELECT p FROM products p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return product;
    }

    public List<Product> findAll() {

        this.entityManager.getTransaction().begin();

        List<Product> products = this.entityManager
                .createQuery("SELECT p FROM products p", Product.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return products;
    }

}
