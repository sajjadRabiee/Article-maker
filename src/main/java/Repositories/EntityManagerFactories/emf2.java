package Repositories.EntityManagerFactories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class emf2 {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit-two");
    private  static EntityManager entityManager;

    private emf2(){}

    public static EntityManager getEntityManager(){
        if (entityManager==null){
            entityManager = entityManagerFactory.createEntityManager() ;
        }
        return entityManager;
    }
}
