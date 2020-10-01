package Repositories.EntityDAO;

import Repositories.EntityManagerFactories.emf1;
import Service.entities.Article;

import javax.persistence.EntityManager;

public class ArticleDAO extends DAOImpl<Article> {

    @Override
    protected Class<Article> getObjClass() {
        return Article.class;
    }

    public ArticleDAO() {
        EntityManager em = emf1.getEntityManager();
        super.em = em;
        setFieldName("title");
        setTableName("article_table");
    }
}
