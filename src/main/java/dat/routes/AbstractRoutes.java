package dat.routes;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.factories.AbstractClass;
import dat.services.InterfaceService;

import java.io.Serializable;

public abstract class AbstractRoutes<   Entity extends AbstractEntity,
                                        DTO extends AbstractDTO,
                                        ID extends Serializable> extends AbstractClass<Entity ,DTO , ID>
{
    public AbstractRoutes(InterfaceService<DTO, Entity, ID> service)
    {
        super();

    }
}
