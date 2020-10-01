package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf1;
import Service.entities.Role;

import javax.persistence.EntityManager;

public class RoleDAO extends DAOImpl<Role> {

    public RoleDAO() {
        EntityManager em = emf1.getEntityManager();
        super.em = em;
        setTableName("role");
        setFieldName("title");
    }

    @Override
    protected Class<Role> getObjClass() {
        return Role.class;
    }
}
