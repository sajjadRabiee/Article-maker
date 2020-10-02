package Repositories.EntityManagerFactories;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class emf1 {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-one");
    private static EntityManager entityManager;

    private emf1(){}

    public static EntityManager getEntityManager(){
        if (entityManager==null){
            entityManager = entityManagerFactory.createEntityManager() ;
        }
        return entityManager;
    }
}
