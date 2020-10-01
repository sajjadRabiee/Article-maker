package Service;


import Service.Menus.MainMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static void main(String[] args) {
        MainMenu.showMenu();
    }
}
