package dat.services;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;

import java.util.Set;

public interface InterfaceService<  DTO extends AbstractDTO,
                                    Entity extends AbstractEntity,
                                    ID extends Object>
{
    DTO create(DTO dto);

    DTO read(ID id);

    DTO update(ID id, DTO dto);

    void delete(ID id);

    DTO update(Entity entity, DTO dto);

    void delete(Entity entity);

    DTO read(Entity entity);

    Set<DTO> readAllDTO();

    // Set<Entity> readAllEntity();

    Entity dtoToEntity(DTO dto);

    DTO entityToDTO(Entity entity);

    Class<DTO> getDtoClass();
}
