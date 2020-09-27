package Service.Process;

import Service.Input.InputArea;
import Service.entities.User;

import javax.persistence.EntityManager;

public class AboutOnlineUser {
    public static void showUserInformation(User onlineUser){
        System.out.println("----- "+ onlineUser.getRole() +" -----");
        System.out.println("Your username : " + onlineUser.getUsername());
        System.out.println("Your National Code : " + onlineUser.getNationalCode());
        System.out.println("Your Birthday : " + onlineUser.getBirthday());
        System.out.println("Your Password : " + onlineUser.getPassword());
    }

    public static void editPassword(User onlineUser , EntityManager em){
        System.out.println("Please enter your old password : ");
        while(true) {
            String oldPassword = InputArea.getPassword();
            if (oldPassword.equals(onlineUser.getPassword())) {
                break;
            } else {
                System.out.print("your old password is not correct please try again : ");
                continue;
            }
        }
        while(true) {
            System.out.println("Please Enter new password");
            String newPassword1 = InputArea.getPassword();
            System.out.println("Please Enter new password again");
            String newPassword2 = InputArea.getPassword();
            if (newPassword1.equals(newPassword2)) {
                onlineUser.setPassword(newPassword1);
                System.out.println("your password successfully changed");
                break;
            } else {
                System.out.println("your passwords is not same please try again");
                continue;
            }
        }
    }
}
