package Repositories;

import Service.entities.Category;

import javax.persistence.EntityManager;

public class CategoryDAO extends DAOImpl<Category> {

    public CategoryDAO(EntityManager em) {
        super(em, Category.class);
        setTableName("category");
        setFieldName("title");
    }
}
