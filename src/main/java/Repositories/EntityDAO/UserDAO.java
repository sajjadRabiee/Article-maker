package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf1;
import Service.entities.User;
import javax.persistence.EntityManager;

public class UserDAO extends DAOImpl<User> {

    @Override
    protected Class<User> getObjClass() {
        return User.class;
    }

    public UserDAO() {
        EntityManager em = emf1.getEntityManager();
        super.em = em;
        setTableName("user_table");
        setFieldName("username");
    }
}
