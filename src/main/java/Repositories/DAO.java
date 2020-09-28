package Repositories;

import java.util.List;
import java.util.Optional;

public interface DAO<Obj> {
    Obj selectById(long id);
    Obj selectByName(String str);
    List<Obj> selectAll();
    Boolean add(Obj object);
    Boolean delete(Obj object);
    Boolean update(Obj object);
}
