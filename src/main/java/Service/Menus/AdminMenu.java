package Service.Menus;


import Service.Input.InputArea;
import Service.entities.User;

public final class AdminMenu {
    public static void ShowAdminMenu(User onlineUser){
        outter:
        while (true) {
            System.out.println("----------------------- Admin -----------------------\n" +
                    "0.For go back\n" +
                    "1.Show all Articles\n" +
                    "2.Show my articles\n" +
                    "3.Publish article of users" +
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
                    break outter;
                }
                //Show
                case 1: {
                }
                //Edit
                case 2: {
                }
                //Add
                case 3: {
                }

                case 4:{
                }
                case 5:{
                }
            }
        }
    }
}