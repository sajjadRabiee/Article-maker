package Repositories;

import Service.entities.Tag;

import javax.persistence.EntityManager;

public class TagDAO extends DAOImpl<Tag> {
    @Override
    protected Class<Tag> getObjClass() {
        return Tag.class;
    }

    public TagDAO(EntityManager em) {
        super(em);
        setTableName("tag");
        setFieldName("title");
    }
}
