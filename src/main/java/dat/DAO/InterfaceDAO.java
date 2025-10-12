package dat.DAOs;

import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceDAO<  Entity  extends AbstractEntity,
                                DTO     extends AbstractDTO,
                                ID      extends Serializable>
{
    Class<Entity> getEntityClass();
    Optional<Entity> read(ID id);
    List<Entity> readAll();
    Entity create(Entity entity);
    Optional<Entity> update(ID id, Entity entity);
    void delete(ID id);
    boolean validatePrimaryKey(ID id);

    Optional<Entity> executeJPQL(String jpql, Map<String, Object> params);
}
