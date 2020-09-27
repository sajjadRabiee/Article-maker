package Service.Menus;

import Service.Input.InputArea;
import Service.Process.Login;
import Service.Process.Register;
import Service.entities.User;

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
                    if (onlineUser.getRole().getTitle() == "admin"){
                        AdminMenu.ShowAdminMenu(onlineUser);
                    }else if(onlineUser.getRole().getTitle() == "writer"){
                        WriterMenu.showWriterMenu(onlineUser);
                    }
                }
                //Register
                case 2: {
                    Register.registerProcess();
                }
                //Search
                case 3: {

                }
            }
        }
    }
}
