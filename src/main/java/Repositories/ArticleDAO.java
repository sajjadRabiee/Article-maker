package Repositories;

import Service.entities.Article;

import javax.persistence.EntityManager;

public class ArticleDAO extends DAOImpl<Article> {

    @Override
    protected Class<Article> getObjClass() {
        return Article.class;
    }

    public ArticleDAO(EntityManager em) {
        super(em);
        setFieldName("title");
        setTableName("article_table");
    }
}
