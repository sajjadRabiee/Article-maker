package Service.Process;

import Repositories.CategoryDAO;
import Repositories.TagDAO;
import Service.Input.InputArea;
import Service.entities.Tag;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AboutTag {
    public static void showAllTag(EntityManager em){
        TagDAO tagDAO = new TagDAO(em);
        for(Tag tag : tagDAO.selectAll()){
            System.out.println("Title : " + tag.getTitle());
        }
    }

    public static void addTag(EntityManager em){
        TagDAO tagDAO = new TagDAO(em);
        outter : while(true){
            System.out.println("please enter name of your tag :");
            String name = InputArea.getName();
            Optional<Tag> oTag = tagDAO.selectByName(name);
            if(oTag.isPresent()){
                System.out.println("your tag is exist do you want see tags that exist");
                if(InputArea.getBool()){
                    showAllTag(em);
                } continue outter;
            }else{
                Tag tag = new Tag();
                tag.setTitle(name);
                tagDAO.add(tag);
                break;
            }
        }
    }

    public static Tag chooseTag(EntityManager em){
        showAllTag(em);
        TagDAO tagDAO = new TagDAO(em);
        String titleTag;
        System.out.println("please enter title of Tag you want : ");
        while (true) {
            titleTag = InputArea.getName();
            if (tagDAO.selectByName(titleTag).equals(Optional.empty())) {
                System.out.println("your Tag is not found \n" +
                        "you can request your category from admins");
                continue;
            } else {
                break;
            }
        }
        return  tagDAO.selectByName(titleTag).get();
    }
}
