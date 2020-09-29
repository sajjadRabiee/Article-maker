package Repositories;

import Service.entities.Category;

import javax.persistence.EntityManager;

public class CategoryDAO extends DAOImpl<Category> {

    @Override
    protected Class<Category> getObjClass() {
        return Category.class;
    }

    public CategoryDAO(EntityManager em) {
        super(em);
        setTableName("category");
        setFieldName("title");
    }
}
