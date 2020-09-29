package Service;


import Repositories.UserDAO;
import Service.Menus.MainMenu;
import Service.Process.StaticRoles;
import Service.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    public static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        MainMenu.showMenu(em);
        em.close();
        emf.close();

    }
}
