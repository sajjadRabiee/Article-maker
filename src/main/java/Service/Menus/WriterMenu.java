package Service.Menus;

import Repositories.UserDAO;
import Service.Input.InputArea;
import Service.Process.AboutArticle;
import Service.Process.AboutOnlineUser;
import Service.entities.User;

import javax.persistence.EntityManager;

public final class WriterMenu {
    public static void showWriterMenu (User onlineUser , EntityManager em){
        UserDAO userDAO = new UserDAO(em);
        outter:
        while (true) {
            System.out.println("----------------------- Writer -----------------------\n" +
                    "0.For go back\n" +
                    "1.Show my articles\n" +
                    "2.Edit my article\n" +
                    "3.Add new article\n" +
                    "4.Show my information\n" +
                    "5.Edit my password\n" +
                    "type your choice :");
            inner:
            switch (InputArea.getMenuNumber(5)) {
                case 0: {
                    userDAO.update(onlineUser);
                    break outter;
                }
                //Show
                case 1: {
                    AboutArticle.showArticleOfOnlineUser(onlineUser);
                    break inner;
                }
                //Edit
                case 2: {
                    AboutArticle.showArticleOfOnlineUser(onlineUser);
                    AboutArticle.editArticleOfOnlineUser(onlineUser,em);
                    userDAO.update(onlineUser);
                    break inner;
                }
                //Add
                case 3: {
                    AboutArticle.addArticleOfOnlineUser(onlineUser,em);
                    userDAO.update(onlineUser);
                    break;
                }
                case 4:{
                    AboutOnlineUser.showUserInformation(onlineUser);
                    break;
                }
                case 5:{
                    AboutOnlineUser.editPassword(onlineUser,em);
                    userDAO.update(onlineUser);
                    break;
                }
            }
        }
    }


}
