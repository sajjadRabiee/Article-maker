package Repositories;

import Service.entities.User;
import javax.persistence.EntityManager;

public class UserDAO extends DAOImpl<User> {

    public UserDAO(EntityManager em) {
        super(em, User.class);
        setTableName("user_table");
        setFieldName("username");
    }
}
