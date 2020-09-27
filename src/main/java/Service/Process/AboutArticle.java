package Service.Process;

import Repositories.ArticleDAO;
import Service.Input.InputArea;
import Service.entities.Article;
import Service.entities.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class AboutArticle {
    public static void showArticleOfOnlineUser(User onlineUser) {
        for (Article a : onlineUser.getArticles()) {
            showArticleComplete(a);
        }
    }

    public static void showArticleComplete(Article article) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("title : " + article.getTitle());
        System.out.println("Category : " + article.getCategory());
        System.out.println("brief : " + article.getBrief());
        System.out.println("content : \n" + article.getContent());
        System.out.println("tags : " + article.getTags());
        System.out.println("Date of Create : " + article.getCreateDate());
        String status = null;
        if (article.isPublished()) {
            status = "Is Published";
        } else {
            status = "Unpublished";
        }
        System.out.println("Status : " + status);
        System.out.println("-----------------------------------------------------------");
    }

    public static void showArticleBrief(Article article){
        System.out.println("-----------------------------------------------------------");
        System.out.println("title : " + article.getTitle());
        System.out.println("Category : " + article.getCategory());
        System.out.println("brief : " + article.getBrief());
        System.out.println("-----------------------------------------------------------");
    }

    public static void showAllOfArticles(EntityManager em){
        ArticleDAO articleDAO = new ArticleDAO(em);
        for(Article a : articleDAO.selectAll()){
            showArticleBrief(a);
        }
    }

    public static void EditArticleOfOnlineUser(User onlineUser , EntityManager em) {
        ArticleDAO articleDAO = new ArticleDAO(em);
        System.out.println("please enter name of your article");
        String articleName = InputArea.getName();
        for(Article a : onlineUser.getArticles()){
            if(a.getTitle().equals(articleName)){
                Article onlineArticle = articleDAO.selectByName(articleName).get();
                System.out.print("\n----- What do you want to edit -----\n" +
                        "1. title \n" +
                        "2. brief \n" +
                        "3. content \n" +
                        "please enter your choice : ");
                switch (InputArea.getMenuNumber(3)){
                    case 1 : {
                        System.out.println("current title : \n" + onlineArticle.getTitle());
                        System.out.print("please type your new content : ");
                        while(true) {
                            String articleTitle = InputArea.getName();
                            if (articleDAO.selectByName(articleName).equals(Optional.empty())) {
                                onlineArticle.setTitle(articleTitle);
                                break;
                            } else {
                                System.out.println("this name has already exist in our article bank please choose another one :");
                                continue;
                            }
                        }
                        break;
                    }
                    case 2 : {
                        System.out.println("current brief : \n" + onlineArticle.getBrief());
                        System.out.print("please type your new content : ");
                        String articleBrief = InputArea.getText();
                        onlineArticle.setBrief(articleBrief);
                        break;
                    }
                    case 3 : {
                        System.out.println("current content : \n" + onlineArticle.getContent());
                        System.out.print("please type your new content : ");
                        String articleContent = InputArea.getText();
                        onlineArticle.setContent(articleName);
                        break;
                    }
                }
                articleDAO.update(onlineArticle);
            }else{
                System.out.println("there is not any article by this name that for you");
            }
        }
    }
}
