package Repositories;

import Service.entities.Tag;

import javax.persistence.EntityManager;

public class TagDAO extends DAOImpl<Tag> {
    public TagDAO(EntityManager em, Class<Tag> tagClass) {
        super(em, tagClass);
        setTableName("tag");
        setFieldName("title");
    }
}
