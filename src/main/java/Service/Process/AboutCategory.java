package Service.Process;

import Repositories.CategoryDAO;
import Service.Input.InputArea;
import Service.entities.Category;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AboutCategory {
    public static void showAllCategory(EntityManager em){
        CategoryDAO categoryDAO = new CategoryDAO(em);
        int i = 0;
        for(Category cate : categoryDAO.selectAll()){
            i++;
            System.out.println("-----------------------------------------------------------");
            System.out.println(i + ". title : " + cate.getTitle());
            System.out.println("description : " + cate.getDescription());
            System.out.println("-----------------------------------------------------------");
        }
    }

    public static Category chooseCategory(EntityManager em){
        CategoryDAO categoryDAO = new CategoryDAO(em);
        String titleCategory;
        System.out.println("please enter title of category you want : ");
        while (true) {
            titleCategory = InputArea.getName();
            if (categoryDAO.selectByName(titleCategory).equals(Optional.empty())) {
                System.out.println("your category is not found \n" +
                        "you can request your category from admins");
                continue;
            } else {
                break;
            }
        }
        return categoryDAO.selectByName(titleCategory);
    }
}
