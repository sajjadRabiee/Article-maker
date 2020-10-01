package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf1;
import Service.entities.Tag;

import javax.persistence.EntityManager;

public class TagDAO extends DAOImpl<Tag> {
    @Override
    protected Class<Tag> getObjClass() {
        return Tag.class;
    }

    public TagDAO() {
        EntityManager em = emf1.getEntityManager();
        super.em = em;
        setTableName("tag");
        setFieldName("title");
    }
}
