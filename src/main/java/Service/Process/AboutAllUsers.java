//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Service.Process;

import Repositories.EntityDAO.UserDAO;
import Repositories.EntityDAO.UserInfoDAO;
import Service.Input.InputArea;
import Service.entities.User;
import Service.entities.UserInfo;
import java.util.function.Function;
import java.util.function.Predicate;

public class AboutAllUsers {
    public AboutAllUsers() {
    }

    public static void editRoleOfUsers() {
        UserDAO userDAO = new UserDAO();
        System.out.println("please enter username of user that you want edit role of him : ");
        while(true) {
            String username = InputArea.getUsername();
            if (!userDAO.selectByName(username).isPresent()) {
                System.out.println("This username is not found\n" +
                        "do you want to show all users :");
                if (InputArea.getBool()) {
                    showAllUsers();
                    continue;
                } else {
                    continue;
                }
            }else{
                User currentUser = (User) userDAO.selectByName(username).get();
                System.out.println("current Role for user " + currentUser.getUsername() + " is " + currentUser.getRole().getTitle());
                System.out.println("Do you want to change it ?");
                if (InputArea.getBool()){
                    if(currentUser.getRole().equals(StaticRoles.getAdminRole())){
                        currentUser.setRole(StaticRoles.getWriterRole());
                    } else {
                        currentUser.setRole(StaticRoles.getAdminRole());
                    }

                    userDAO.update(currentUser);
                }
            }
        }
    }

    protected static void showAllUsers() {
        UserDAO userDAO = new UserDAO();
        for(User user : userDAO.selectAll()){
            showUserInfo(user);
        }

    }

    protected static void showUserInfo(User user){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Role : " + user.getRole().getTitle());
        System.out.println("-----------------------------------------------------------");
    }

    public static void castUsers() {
        UserDAO userDAO = new UserDAO();
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        Function<User, UserInfo> function = (a) -> {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(a.getId());
            userInfo.setUsername(a.getUsername());
            userInfo.setAddress(a.getAddress());
            userInfo.setNationalCode(a.getNationalCode());
            return userInfo;
        };
        userDAO.castAll(function);
        for(UserInfo uI : userInfoDAO.selectAll()){
            System.out.println(uI.getId());
            System.out.println(uI.getUsername());
            System.out.println(uI.getAddress().getCountry());
            System.out.println(uI.getNationalCode());
        }
    }

    public static void findUser() {
        UserDAO userDAO = new UserDAO();
        Predicate<User> predicate = (a) -> a.getRole().getTitle().equals("Admin");
        for(User u : userDAO.findAll(predicate)){
            showUserInfo(u);
        }
    }
}
