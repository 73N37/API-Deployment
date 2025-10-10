package dat.daos;

import dat.Unit;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceDAO<  Entity extends Unit,
                                ID extends Object> {

    Class<Entity> getEntityClass();
    Optional<Entity> read(ID id);
    List<Entity> readAll();
    Entity create(Entity entity);
    Optional<Entity> update(ID id, Entity entity);
    void delete(ID id);
    boolean validatePrimaryKey(ID id);
    Optional<Entity> executeJPQL(String jpql, Map<String, Object> params);
}
