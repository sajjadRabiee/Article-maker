package Service.Process;

import Repositories.EntityDAO.UserDAO;
import Service.Input.InputArea;
import Service.entities.User;

import javax.persistence.EntityManager;

public class AboutAllUsers {
    public static void editRoleOfUsers(){
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
                    }else {
                        currentUser.setRole(StaticRoles.getAdminRole());
                    }
                    userDAO.update(currentUser);
                }else{
                    break;
                }
            }
        }
    }

    protected static void showAllUsers(){
        UserDAO userDAO = new UserDAO();
        for(User user : userDAO.selectAll()){
            System.out.println("-----------------------------------------------------------");
            System.out.println("Username : " + user.getUsername());
            System.out.println("Role : " + user.getRole().getTitle());
            System.out.println("-----------------------------------------------------------");

        }
    }
}
