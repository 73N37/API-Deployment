package dat.Factories;

import dat.Controllers.InterfaceController;
import dat.Controllers.impl.AbstractController;
import dat.DAOs.InterfaceDAO;
import dat.DAOs.impl.AbstractDAO;
import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;
import dat.Routes.AbstractRoutes;
import dat.Routes.InterfaceRoutes;
import dat.Services.AbstractService;
import dat.Services.InterfaceService;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class Factory<   Entity  extends AbstractEntity<Entity, ID>,
                        DTO     extends AbstractDTO<DTO,ID>,
                        ID      extends Serializable>
                                extends AbstractFactory<Entity, DTO, ID>
{
    protected final EntityManagerFactory    emf;
    public InterfaceController              controller;
    public InterfaceDAO                     dao;
    public InterfaceService                 service;
    public InterfaceRoutes                  routes;

    public Factory(Class<Entity>        entityClass,
                   Class<DTO>           dtoClass,
                   Class<ID>            idClass,
                   EntityManagerFactory emf)
    {
        super(entityClass, dtoClass, idClass);
        this.emf =          emf;
    }

    public void create()
    {
        createDAO(emf);
        createService();
        createController();
        createRoutes();
    }

    public InterfaceDAO<Entity, DTO, ID> createDAO(EntityManagerFactory emf)
    {
        this.dao = new AbstractDAO<>(emf, entityClass, dtoClass, idClass) {};
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
