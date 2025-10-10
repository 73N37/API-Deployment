package dat.factories;

import dat.controllers.InterfaceController;
import dat.controllers.impl.AbstractController;
import dat.daos.InterfaceDAO;
import dat.daos.impl.AbstractDAO;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.services.AbstractService;
import dat.services.InterfaceService;
import jakarta.persistence.EntityManagerFactory;

import java.io.Serializable;

public class Factory <  Entity  extends AbstractEntity,
                        DTO     extends AbstractDTO,
                        ID      extends Serializable>
{
    private final Class<Entity> entityClass;
    private final Class<DTO> dtoClass;
    private final Class<ID> idClass;

    public Factory (Class<Entity> entityClass, Class<DTO> dtoClass, Class<ID> idClass)
    {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.idClass = idClass;
    }

    public InterfaceDAO<Entity, DTO, ID> createDAO(EntityManagerFactory emf)
    {
        return new AbstractDAO<Entity, DTO, ID>(emf, entityClass, idClass) {};
    }

    public InterfaceService<Entity, DTO, ID> createService(InterfaceDAO<Entity, DTO, ID> dao)
    {
        return new AbstractService<Entity, DTO, ID>(dao,entityClass, dtoClass, idClass) {};
    }

    public InterfaceController<Entity, DTO, ID> createController(InterfaceService<Entity, DTO, ID> service)
    {
        return new AbstractController<Entity, DTO, ID>(service, entityClass, dtoClass, idClass) {};
    }

    public InterfaceRoute<Entity, DTO, ID> createRoutes(InterfaceService<Entity, DTO, ID> controller)
    {
        return new AbstractRoute<Entity, DTO, ID>(controller, entityClass, dtoClass, idClass);
    }
}
