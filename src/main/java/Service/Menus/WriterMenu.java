package Service.Menus;

import Service.Input.InputArea;
import Service.entities.User;

public final class WriterMenu {
    public static void showWriterMenu (User onlineUser){
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
