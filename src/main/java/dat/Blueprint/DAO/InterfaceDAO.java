package dat.Blueprint.DAO;

import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceDAO<  Entity  extends AbstractEntity,
                                ID      extends Serializable>
{
    //Class<Entity> getEntityClass();
    Optional<Entity> get(ID id);
    List<Entity> getAll();
    Entity post(Entity entity);
    Optional<Entity> put(ID id, Entity entity);
    void delete(ID id);
    boolean validatePrimaryKey(ID id);

    Optional<Entity> executeJPQL(String jpql, Map<String, Object> params);
}
