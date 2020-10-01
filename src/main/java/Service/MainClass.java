package Service;


import Repositories.UserDAO;
import Service.Menus.MainMenu;
import Service.Process.StaticRoles;
import Service.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("my-persistence-unit-one");
    public static EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("my-persistence-unit-two");
    public static EntityManager em1 = emf1.createEntityManager();
    public static EntityManager em2 = emf2.createEntityManager();
    public static void main(String[] args) {
        MainMenu.showMenu(em1,em2);
        em1.close();
        emf1.close();
        em2.close();
        emf2.close();

    }
}
