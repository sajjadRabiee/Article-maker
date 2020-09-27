package Repositories;

import Service.entities.Role;

import javax.persistence.EntityManager;

public class RoleDAO extends DAOImpl<Role> {

    public RoleDAO(EntityManager em, Class<Role> roleClass) {
        super(em, roleClass);
        setTableName("role");
        setFieldName("title");
    }
}
