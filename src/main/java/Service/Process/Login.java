package Service.Process;

import Repositories.EntityDAO.UserDAO;
import Repositories.EntityManagerFactories.emf1;
import Service.Input.InputArea;
import Service.entities.User;

import java.util.Optional;

public final class Login {

    public static User loginProcess() {
        UserDAO userDAO = new UserDAO();

        String username;
        outter : while (true) {
            System.out.print("please enter username : ");
            username = InputArea.getUsername();
            Optional<User> oUser = userDAO.selectByName(username);
            if (oUser.isPresent()) {
                User user = oUser.get();
                inner : while (true) {
                    System.out.print("please enter your password : ");
                    String password = InputArea.getPassword();
                    if (password.equals(user.getPassword())) {
                        return userDAO.selectByName(username).get();
                    } else {
                        System.out.println("password is not corrected");
                        continue inner;
                    }
                }
            } else {
                System.out.println("This user not found please check username and try again");
                continue outter;
            }
        }
    }
}
