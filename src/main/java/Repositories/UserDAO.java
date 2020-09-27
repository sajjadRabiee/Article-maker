package Repositories;

import Service.entities.User;
import javax.persistence.EntityManager;

public class UserDAO extends DAOImpl<User> {

    public UserDAO(EntityManager em, Class<User> tagClass) {
        super(em, tagClass);
        setTableName("user_table");
        setFieldName("username");
    }
}
