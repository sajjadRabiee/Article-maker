package Service.Process;

import Repositories.UserDAO;
import Service.Input.InputArea;
import Service.entities.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public final class Login {

    public static User loginProcess(EntityManager em) {
        UserDAO userDAO = new UserDAO(em);
        String username;
        while (true) {
            System.out.print("please enter username : ");
            username = InputArea.getUsername();
            if (userDAO.selectByName(username) instanceof User) {
                System.out.println("This user not found please check username and try again");
                continue;
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("please enter your password : ");
            String password = InputArea.getPassword();
            if (userDAO.selectByName(username).getPassword().equals(password)) {
                return userDAO.selectByName(username);
            } else {
                System.out.println("password is not corrected");
                continue;
            }
        }
    }
}
