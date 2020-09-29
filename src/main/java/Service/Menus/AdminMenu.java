package Service.Menus;


import Repositories.UserDAO;
import Service.Input.InputArea;
import Service.Process.AboutAllUsers;
import Service.Process.AboutArticle;
import Service.Process.AboutOnlineUser;
import Service.entities.User;

import javax.persistence.EntityManager;

public final class AdminMenu {
    public static void ShowAdminMenu(User onlineUser, EntityManager em){
        UserDAO userDAO = new UserDAO(em);
        outter:
        while (true) {
            System.out.println("----------------------- Admin -----------------------\n" +
                    "0.For go back\n" +
                    "1.Show all Articles\n" +
                    "2.Show my articles\n" +
                    "3.Publish article of users\n" +
                    "4.Edit my article\n" +
                    "5.Edit role of users\n" +
                    "6.Add new Category\n" +
                    "7.Add new Tag" +
                    "8.Add new article\n" +
                    "9.Show my information\n" +
                    "10.Edit my password\n" +
                    "type your choice :");
            inner:
            switch (InputArea.getMenuNumber(10)) {
                case 0: {
                    userDAO.update(onlineUser);
                    break outter;
                }
                case 1: {
                    AboutArticle.showAllOfArticles(em);
                    break inner;
                }
                case 2: {
                    AboutArticle.showArticleOfOnlineUser(onlineUser);
                    break inner;
                }
                case 3: {
                    AboutArticle.publishArticleOfOnlineUser(em);
                    break inner;
                }
                case 4:{
                    AboutArticle.editArticleOfOnlineUser(onlineUser,em);
                    userDAO.update(onlineUser);
                    break inner;
                }
                case 5:{
                    AboutAllUsers.editRoleOfUsers(em);
                    break inner;
                }
                case 6:{
                    //dar dast sakht
                    System.out.println("dar dast sakht");
                    break inner;
                }
                case 7:{
                    //dar dast sakht
                    System.out.println("dar dast sakht");
                    break inner;
                }
                case 8:{
                    AboutArticle.addArticleOfOnlineUser(onlineUser , em);
                    userDAO.update(onlineUser);
                    break inner;
                }
                case 9:{
                    AboutOnlineUser.showUserInformation(onlineUser);
                    break;
                }
                case 10:{
                    AboutOnlineUser.editPassword(onlineUser,em);
                    userDAO.update(onlineUser);
                    break;
                }
            }
        }
    }
}
