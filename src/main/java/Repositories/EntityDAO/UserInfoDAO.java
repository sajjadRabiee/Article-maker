package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf2;
import Service.entities.UserInfo;

import javax.persistence.EntityManager;

public class UserInfoDAO extends DAOImpl<UserInfo> {
    @Override
    protected Class<UserInfo> getObjClass() {
        return UserInfo.class;
    }

    public UserInfoDAO() {
        EntityManager em = emf2.getEntityManager();
        super.em = em;
        setTableName("user_info");
        setFieldName("username");
    }
}
