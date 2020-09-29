package Service.Process;

import Repositories.ArticleDAO;
import Repositories.UserDAO;
import Service.Input.InputArea;
import Service.entities.Article;
import Service.entities.Category;
import Service.entities.Tag;
import Service.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        System.out.println("Category : " + article.getCategory().getTitle());
        System.out.println("brief : " + article.getBrief());
        System.out.println("content : \n" + article.getContent());
        System.out.println("tags : ");
        for(Tag tag : article.getTags()){
            System.out.println(tag.getTitle());
        }
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

    public static void showArticleBrief(Article article) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Title : " + article.getTitle());
        System.out.println("Category : " + article.getCategory().getTitle());
        System.out.println("Brief : " + article.getBrief());
        System.out.println("Writer : " + article.getUserOfArticle().getUsername());
        System.out.println("-----------------------------------------------------------");
    }

    public static void showAllOfArticles(EntityManager em) {
        ArticleDAO articleDAO = new ArticleDAO(em);
        for (Article a : articleDAO.selectAll()) {
            showArticleBrief(a);
        }
    }

    public static void editArticleOfOnlineUser(User onlineUser, EntityManager em) {
        ArticleDAO articleDAO = new ArticleDAO(em);
        System.out.println("please enter name of your article");
        String articleName = InputArea.getName();
        for (Article a : onlineUser.getArticles()) {
            if (a.getTitle().equals(articleName)) {
                Article onlineArticle = (Article) articleDAO.selectByName(articleName).get();
                System.out.print("\n----- What do you want to edit -----\n" +
                        "1. title \n" +
                        "2. brief \n" +
                        "3. content \n" +
                        "please enter your choice : ");
                switch (InputArea.getMenuNumber(3)) {
                    case 1: {
                        System.out.println("current title : \n" + onlineArticle.getTitle());
                        System.out.print("please type your new content : ");
                        while (true) {
                            String articleTitle = InputArea.getName();
                            if (articleDAO.selectByName(articleName).equals(Optional.empty())) {
                                onlineArticle.setTitle(articleTitle);
                                break;
                            } else {
                                System.out.println("this name has already exist in our article bank please choose another one : ");
                                continue;
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("current brief : \n" + onlineArticle.getBrief());
                        System.out.print("please type your new content : ");
                        String articleBrief = InputArea.getText();
                        onlineArticle.setBrief(articleBrief);
                        break;
                    }
                    case 3: {
                        System.out.println("current content : \n" + onlineArticle.getContent());
                        System.out.print("please type your new content : ");
                        String articleContent = InputArea.getText();
                        onlineArticle.setContent(articleName);
                        break;
                    }
                }
                articleDAO.update(onlineArticle);
            } else {
                System.out.println("there is not any article by this name that for you");
            }
        }
    }

    public static void addArticleOfOnlineUser(User onlineUser, EntityManager em) {
        ArticleDAO articleDAO = new ArticleDAO(em);
        Article onlineArticle = new Article();
        onlineArticle.setUserOfArticle(onlineUser);
        System.out.print("please type your Article title : ");
        while (true) {
            String ArticleTitle = InputArea.getName();
            if (articleDAO.selectByName(ArticleTitle).equals(Optional.empty())) {
                onlineArticle.setTitle(ArticleTitle);
                break;
            } else {
                System.out.println("this name has already exist in our article bank please choose another one : ");
                continue;
            }
        }

        System.out.println("----- Categories you can choose -----");
        AboutCategory.showAllCategory(em);
        Category category = AboutCategory.chooseCategory(em);
        onlineArticle.setCategory(category);

        System.out.println("----- Tags you can choose -----");
        AboutTag.showAllTag(em);
        List<Tag> tags = new ArrayList<>();
        tags.add(AboutTag.chooseTag(em));
        while (true){
            System.out.println("Do you want add more tag");
            if(InputArea.getBool()){
                tags.add(AboutTag.chooseTag(em));
                continue;
            }else{
                break;
            }
        }

        onlineArticle.setTags(tags);

        System.out.println("please type your brief : ");
        String brief = InputArea.getText();
        onlineArticle.setBrief(brief);

        System.out.println("please type your content : ");
        String content = InputArea.getText();
        onlineArticle.setContent(content);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        LocalDate localDate = LocalDate.parse(dateFormat.format(currentDate));
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        onlineArticle.setCreateDate(date);
        onlineArticle.setPublishDate(date);
        onlineArticle.setPublished(false);
        articleDAO.add(onlineArticle);
    }

    public static void publishArticleOfOnlineUser(EntityManager em) {
        UserDAO userDAO = new UserDAO(em);
        ArticleDAO articleDAO = new ArticleDAO(em);
        while (true) {
            System.out.println("please enter name of user that you want publish her/him article : ");
            String nameOfUser = InputArea.getUsername();
            Optional<User> oUser = userDAO.selectByName(nameOfUser);
            if (!oUser.isPresent()) {
                System.out.println("This username is not found\n" +
                        "do you want to show all users :");
                if (InputArea.getBool()) {
                    AboutAllUsers.showAllUsers(em);
                    continue;
                } else {
                    continue;
                }
            } else {
                User user = oUser.get();
                showArticleOfOnlineUser(user);
                while (true) {
                    System.out.println("please enter name of article you want edit : ");
                    String nameOfArticle = InputArea.getName();
                    Optional<Article> oArticle = articleDAO.selectByName(nameOfArticle);
                    if (oArticle.isPresent()) {
                        Article article = oArticle.get();
                        showArticleComplete(article);
                        System.out.println("do you want edit article " + article.getTitle() + " for user " + article.getUserOfArticle().getUsername() +"");
                        if (InputArea.getBool()) {
                            article.setPublished(true);
                            articleDAO.update(article);
                            userDAO.update(article.getUserOfArticle());
                            break;
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("This article is not found\n" +
                                "do you want to show all article :");
                        if (InputArea.getBool()) {
                            showAllOfArticles(em);
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
