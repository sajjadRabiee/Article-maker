package Repositories;

import Service.entities.Role;

import javax.persistence.EntityManager;

public class RoleDAO extends DAOImpl<Role> {

    public RoleDAO(EntityManager em) {
        super(em, Role.class);
        setTableName("role");
        setFieldName("title");
    }
}
