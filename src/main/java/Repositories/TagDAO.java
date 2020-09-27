package Repositories;

import Service.entities.Tag;

import javax.persistence.EntityManager;

public class TagDAO extends DAOImpl<Tag> {
    public TagDAO(EntityManager em) {
        super(em, Tag.class);
        setTableName("tag");
        setFieldName("title");
    }
}
