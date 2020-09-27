package Repositories;

import java.util.List;

public interface DAO<Obj> {
    Obj selectById(long id);
    Obj selectByName(String str);
    List<Obj> selectAll();
    Boolean add(Obj object);
    Boolean delete(Obj object);
    Boolean update(Obj object);
}
