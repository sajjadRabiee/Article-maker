package Service.Process;

import Repositories.ArticleDAO;
import Service.entities.Article;
import Service.entities.User;

import javax.persistence.EntityManager;

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
}
