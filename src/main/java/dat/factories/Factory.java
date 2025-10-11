package dat.factories;

import dat.controllers.InterfaceController;
import dat.controllers.impl.AbstractController;
import dat.daos.InterfaceDAO;
import dat.daos.impl.AbstractDAO;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.routes.AbstractRoutes;
import dat.routes.InterfaceRoutes;
import dat.services.AbstractService;
import dat.services.InterfaceService;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class Factory<       Entity  extends AbstractEntity<Entity, ID>,
                            DTO     extends AbstractDTO<DTO,ID>,
                            ID      extends Serializable>
{
    protected final Class<Entity>   entityClass;
    protected final Class<DTO>      dtoClass;
    protected final Class<ID>       idClass;
    public InterfaceController      controller;
    public InterfaceDAO             dao;
    public InterfaceService         service;
    public InterfaceRoutes          routes;

    public Factory(Class<Entity>    entityClass,
                   Class<DTO>       dtoClass,
                   Class<ID>        idClass)
    {
        this.entityClass =  entityClass;
        this.dtoClass =     dtoClass;
        this.idClass =      idClass;
    }

    public void create()
    {
        createDAO();
        createService();
        createController();
        createRoutes();
    }

    public InterfaceDAO<Entity, DTO, ID> createDAO()
    {
        this.dao = new AbstractDAO<>(Entity.getEMF(), entityClass, dtoClass, idClass) {};
        return dao;
    }

    public InterfaceService<Entity, DTO, ID> createService()
    {
        this.service = new AbstractService<>(dao, entityClass, dtoClass, idClass) {};
        return service;
    }

    public InterfaceController<Entity, DTO, ID> createController()
    {
        this.controller = new AbstractController<>(service, entityClass, dtoClass, idClass) {};
        return controller;
    }

    public InterfaceRoutes<Entity, DTO, ID> createRoutes()
    {
        this.routes = new AbstractRoutes<>(controller, entityClass, dtoClass, idClass) {};
        return routes;
    }
}
