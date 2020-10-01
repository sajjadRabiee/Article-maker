package Repositories.EntityDAO;

import Service.entities.EntityInterface;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class  DAOImpl<Obj extends EntityInterface> implements DAO<Obj> {
    protected EntityManager em;
    protected abstract Class<Obj> getObjClass();
    protected String tableName , fieldName;

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public DAOImpl(){
    }

    @Override
    public Optional<Obj> selectById(long id) {
        Obj obj;
        try{
            obj = em.find(getObjClass() ,id);
        }catch(NoResultException e) {
            obj = null;
        }
        return obj != null ? Optional.of(obj) : Optional.ofNullable(null);
    }

    @Override
    public Optional<Obj> selectByName(String str) {
        Obj obj;
        try{
            TypedQuery<Obj> query = em.createQuery("select e from "+getObjClass().getName()+" e where e."+fieldName+" = \'"+str+"\'",getObjClass());
            obj = query.getSingleResult();
        }catch (NoResultException e){
            obj = null;
        }
        return obj != null ? Optional.of(obj) : Optional.ofNullable(null);
    }

    @Override
    public List<Obj> selectAll() {
        TypedQuery<Obj> query = em.createQuery("select e from "+getObjClass().getName()+" e",getObjClass());
        List<Obj> objects = query.getResultList();
        return objects;
    }

    public List findAll(Predicate<? super Obj> p){
        TypedQuery<Obj> query = em.createQuery("select e from "+getObjClass().getName()+" e",getObjClass());
        List<Obj> objects = query.getResultList();
        return objects.stream().filter(p).collect(Collectors.toList());
    }

    public <desObj extends EntityInterface> List<EntityInterface> findAll(Function<Obj,desObj> f){
        TypedQuery<Obj> query = em.createQuery("select e from "+getObjClass().getName()+" e",getObjClass());
        List<Obj> objects = query.getResultList();
        Consumer<desObj> consumer = a -> {
            try {
                em.getTransaction().begin();
                em.persist(a);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        };
        objects.stream().map(f).forEach(consumer);
        return objects.stream().map(f).collect(Collectors.toList());
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
            TypedQuery<Obj> query = em.createQuery("delete e from"+getObjClass().getName()+" e where e."+fieldName+" = \""+id+"\"", getObjClass() );
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
