package Service.Menus;


import Repositories.EntityDAO.UserDAO;
import Service.Input.InputArea;
import Service.Process.*;
import Service.entities.User;

import javax.persistence.EntityManager;

public final class AdminMenu {
    public static void ShowAdminMenu(User onlineUser){
        UserDAO userDAO = new UserDAO();
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
                    "7.Add new Tag\n" +
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
                    AboutArticle.showAllOfArticles();
                    break inner;
                }
                case 2: {
                    AboutArticle.showArticleOfOnlineUser(onlineUser);
                    break inner;
                }
                case 3: {
                    AboutArticle.publishArticleOfOnlineUser();
                    break inner;
                }
                case 4:{
                    AboutArticle.editArticleOfOnlineUser(onlineUser);
                    userDAO.update(onlineUser);
                    break inner;
                }
                case 5:{
                    AboutAllUsers.editRoleOfUsers();
                    break inner;
                }
                case 6:{
                    AboutCategory.addCategory();
                    break inner;
                }
                case 7:{
                    AboutTag.addTag();
                    break inner;
                }
                case 8:{
                    AboutArticle.addArticleOfOnlineUser(onlineUser);
                    userDAO.update(onlineUser);
                    break inner;
                }
                case 9:{
                    AboutOnlineUser.showUserInformation(onlineUser);
                    break;
                }
                case 10:{
                    AboutOnlineUser.editPassword(onlineUser);
                    userDAO.update(onlineUser);
                    break;
                }
            }
        }
    }
}
