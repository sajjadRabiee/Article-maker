package Service.Menus;

import Service.Input.InputArea;
import Service.Process.AboutArticle;
import Service.Process.Login;
import Service.Process.Register;
import Service.entities.User;

import javax.persistence.EntityManager;

public final class MainMenu {
    public static User onlineUser = new User();

    public static void showMenu(EntityManager em) {

        firstPage:
        while (true) {

            System.out.print("1.Login\n" +
                    "2.Register\n" +
                    "3.Search\n" +
                    "type your choice : ");
            inner:
            switch (InputArea.getMenuNumber(3)) {
                //Login
                case 1: {
                    onlineUser = Login.loginProcess();
                    if (onlineUser.getRole().getTitle() == "admin"){
                        AdminMenu.ShowAdminMenu(onlineUser,em);
                    }else if(onlineUser.getRole().getTitle() == "writer"){
                        WriterMenu.showWriterMenu(onlineUser,em);
                    }
                }
                //Register
                case 2: {
                    Register.registerProcess(em);
                }
                //Search
                case 3: {
                    AboutArticle.showAllOfArticles(em);
                }
            }
        }
    }
}
