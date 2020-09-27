package Service.Process;

import Service.entities.Article;
import Service.entities.User;

public class AboutArticle {
    public static void showArticleOfOnlineUser(User onlineUser){
        for (Article a : onlineUser.getArticles()) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("title : " + a.getTitle());
            System.out.println("Category : " + a.getCategory());
            System.out.println("brief : " + a.getBrief());
            System.out.println("content : \n" + a.getContent());
            System.out.println("tags : " + a.getTags());
            System.out.println("Date of Create : " + a.getCreateDate());
            String status = null;
            if(a.isPublished()){
                status = "Is Published";
            }else{
                status = "Unpublished";
            }
            System.out.println("Status : " + status);
            System.out.println("-----------------------------------------------------------");
        }

    }
}
