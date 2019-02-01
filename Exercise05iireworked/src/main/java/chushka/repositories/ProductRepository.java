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

        this.entityManager.close();

        return entity;
    }

    public Product findById(int id) {



        this.entityManager.getTransaction().begin();

        Product product = this.entityManager
                .createQuery("SELECT p FROM Product p WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return product;
    }

    public Product getByName(String name) {

        this.entityManager.getTransaction().begin();

        Product product = this.entityManager
                .createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return product;
    }

    public List<Product> findAll() {

        this.entityManager.getTransaction().begin();

        List<Product> products = this.entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return products;
    }

}
