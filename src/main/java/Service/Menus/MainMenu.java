package Service.Menus;

import Service.Input.InputArea;
import Service.Process.AboutArticle;
import Service.Process.Login;
import Service.Process.Register;
import Service.entities.User;

import javax.persistence.EntityManager;

public final class MainMenu {
    public static User onlineUser = new User();

    public static void showMenu() {

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
                    System.out.println(onlineUser.getRole().getTitle());
                    if (onlineUser.getRole().getTitle().equals("Admin")){
                        AdminMenu.ShowAdminMenu(onlineUser);
                    }else if(onlineUser.getRole().getTitle().equals("Writer")){
                        WriterMenu.showWriterMenu(onlineUser);
                    }
                    break;
                }
                //Register
                case 2: {
                    onlineUser = Register.registerProcess();
                    WriterMenu.showWriterMenu(onlineUser);
                    break;
                }
                //Search
                case 3: {
                    AboutArticle.showAllOfArticles();
                    break;
                }
            }
        }
    }
}
