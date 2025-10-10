package dat.routes;

import dat.controllers.InterfaceController;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.factories.AbstractClass;
import dat.services.InterfaceService;
import io.javalin.Javalin;

import java.io.Serializable;

public abstract class AbstractRoutes<   Entity  extends AbstractEntity,
                                        DTO     extends AbstractDTO,
                                        ID      extends Serializable>
                                                extends AbstractClass<Entity, DTO, ID>
                                                implements InterfaceRoutes<Entity, DTO, ID>
{
    protected final InterfaceController<Entity, DTO, ID> controller;

    public AbstractRoutes(InterfaceController<Entity, DTO, ID>  controller,
                          Class<Entity>                         entityClass,
                          Class<DTO>                            dtoClass,
                          Class<ID>                             idClass)
    {
        super(entityClass, dtoClass, idClass);
        this.controller = controller;
    }

    public abstract void addRoutes(Javalin app, String basePath);
}
