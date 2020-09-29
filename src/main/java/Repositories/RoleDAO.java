package Repositories;

import Service.entities.Role;

import javax.persistence.EntityManager;

public class RoleDAO extends DAOImpl<Role> {

    public RoleDAO(EntityManager em) {
        super(em);
        setTableName("role");
        setFieldName("title");
    }

    @Override
    protected Class<Role> getObjClass() {
        return Role.class;
    }
}
