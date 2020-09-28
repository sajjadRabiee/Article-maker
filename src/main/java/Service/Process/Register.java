package Service.Process;

import Repositories.UserDAO;
import Service.Input.InputArea;
import Service.entities.User;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.Optional;

public class Register {
    public static User registerProcess(EntityManager em) {
        UserDAO userDAO = new UserDAO(em);
        User newUser = new User();
        newUser.setRole(StaticRoles.getWriterRole());
        System.out.println("Your welcome\n" +
                "Please enter your information below");
        while (true) {
            System.out.print("please enter username : ");
            String username = InputArea.getUsername();
            if (!(userDAO.selectByName(username).equals(Optional.empty()))) {
                System.out.println("this is already exist please enter another username");
                continue;
            } else {
                newUser.setUsername(username);
                break;

            }
        }

        System.out.print("please enter national code : ");
        String nationalCode = InputArea.getNationalCode();
        newUser.setNationalCode(nationalCode);
        newUser.setPassword(nationalCode);

        System.out.print("please enter your birthday : ");
        Date birthday = InputArea.getDate();
        newUser.setBirthday(birthday);

        userDAO.add(newUser);
        return newUser;
    }
}
