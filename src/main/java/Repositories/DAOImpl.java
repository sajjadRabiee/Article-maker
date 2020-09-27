package Repositories;

import Service.entities.EntityInterface;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@NamedQueries(
        {
                @NamedQuery(
                        name = "find",
                        query = "select from :tableName e where e.:fieldName = :fieldValue")
                ,
                @NamedQuery(
                        name = "selectAll",
                        query = "select from :tableName")
                ,
                @NamedQuery(
                        name = "delete" ,
                        query = "delete from :tableName e where e.:fieldName = :fieldValue"
                )
        }
)
public class  DAOImpl<Obj extends EntityInterface> implements DAO<Obj> {
    protected EntityManager em;
    private final Class<Obj> objClass;
    protected String tableName , fieldName;

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DAOImpl(EntityManager em, Class<Obj> objClass){
        this.em = em;
        this.objClass = objClass;
    }

    @Override
    public Optional<Obj> selectById(long id) {
        try{
            Obj obj = em.find(objClass ,id);
            return Optional.of(obj);
        }catch(Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Obj> selectByName(String str) {
        try{
            Query query = em.createNamedQuery("find");
            query.setParameter("tableName", tableName);
            query.setParameter("fieldName", fieldName);
            query.setParameter("fieldValue", str);
            Obj obj = (Obj) query.getSingleResult();
            return Optional.of(obj);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public List<Obj> selectAll() {
        Query query = em.createNamedQuery("selectAll");
        query.setParameter("tableName", tableName);
        List<Obj> objects = query.getResultList();
        return objects;
    }

    @Override
    public Boolean add(Obj object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Boolean delete(Obj object) {
        Long id = object.getId();
        try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("delete");
            query.setParameter("tableName", tableName);
            query.setParameter("fieldName", "id");
            query.setParameter("fieldValue", id);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Boolean update(Obj object) {
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
