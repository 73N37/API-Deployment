package dat.Blueprint.DAO;

import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface InterfaceDAO<  Entity  extends dat.Instance.Entity.Entity,
                                ID      extends Serializable>
{
    //Class<Entity> getEntityClass();
    Entity get(ID id);
    List<Entity> getAllEntities();
    Entity post(Entity entity);
    Entity put(ID id, Entity entity);
    void delete(ID id);
    boolean validatePrimaryKey(ID id);

    Entity executeJPQL(String jpql, Map<String, Object> params);
}
