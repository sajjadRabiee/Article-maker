package Repositories;

import Service.entities.User;
import javax.persistence.EntityManager;

public class UserDAO extends DAOImpl<User> {

    @Override
    protected Class<User> getObjClass() {
        return User.class;
    }

    public UserDAO(EntityManager em) {
        super(em);
        setTableName("user_table");
        setFieldName("username");
    }
}
