package Repositories;

import Service.entities.UserInfo;

import javax.persistence.EntityManager;

public class UserInfoDAO extends DAOImpl<UserInfo> {
    @Override
    protected Class<UserInfo> getObjClass() {
        return UserInfo.class;
    }

    public UserInfoDAO(EntityManager em) {
        super(em);
        setTableName("user_info");
        setFieldName("username");
    }
}
