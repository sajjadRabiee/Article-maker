package Repositories;

import Service.entities.Category;

import javax.persistence.EntityManager;

public class CategoryDAO extends DAOImpl<Category> {

    public CategoryDAO(EntityManager em, Class<Category> categoryClass) {
        super(em, categoryClass);
        setTableName("category");
        setFieldName("title");
    }
}
