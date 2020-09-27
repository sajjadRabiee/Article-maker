package Service;


import Repositories.UserDAO;
import Service.Menus.MainMenu;
import Service.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        MainMenu.showMenu(em);
        em.close();
        emf.close();

    }
}
