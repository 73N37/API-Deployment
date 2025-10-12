package dat.DAO;

import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceDAO<  Entity  extends AbstractEntity,
                                DTO     extends AbstractDTO,
                                ID      extends Serializable>
{
    //Class<Entity> getEntityClass();
    Optional<Entity> get(ID id);
    List<Entity> getAll();
    Entity create(Entity entity);
    Optional<Entity> update(ID id, Entity entity);
    void delete(ID id);
    boolean validatePrimaryKey(ID id);

    Optional<Entity> executeJPQL(String jpql, Map<String, Object> params);
}
