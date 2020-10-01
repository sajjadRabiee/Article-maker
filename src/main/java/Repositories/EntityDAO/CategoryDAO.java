package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf1;
import Service.entities.Category;

import javax.persistence.EntityManager;

public class CategoryDAO extends DAOImpl<Category> {

    @Override
    protected Class<Category> getObjClass() {
        return Category.class;
    }

    public CategoryDAO() {
        EntityManager em = emf1.getEntityManager();
        super.em = em;
        setTableName("category");
        setFieldName("title");
    }
}
