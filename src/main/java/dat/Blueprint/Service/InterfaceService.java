package dat.Blueprint.Service;
import dat.Instance.Entity.Entity;
import dat.Blueprint.DTO.AbstractDTO;
import java.io.Serializable;
import java.util.Set;

public interface InterfaceService<  Entity  extends     dat.Instance.Entity.Entity,
                                    DTO     extends     dat.Instance.DTO.DTO,
                                    ID      extends     Serializable>
{
    DTO create(DTO dto);

    DTO read(ID id);

    DTO update(ID id, DTO dto);

    void delete(ID id);

    void delete(Entity entity);

    DTO read(Entity entity);

    Set<DTO> getAllDTOs();

    Set<Entity> getAllEntities();

    Entity dtoToEntity(DTO dto);

    DTO entityToDTO(Entity entity);
}
