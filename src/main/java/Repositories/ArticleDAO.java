package Repositories;

import Service.entities.Article;

import javax.persistence.EntityManager;

public class ArticleDAO extends DAOImpl<Article> {

    public ArticleDAO(EntityManager em) {
        super(em, Article.class);
        setFieldName("title");
        setTableName("article_table");
    }
}
