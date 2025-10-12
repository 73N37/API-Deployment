package dat.Factory;

import dat.Controller.InterfaceController;
import dat.Controller.impl.AbstractController;
import dat.DAO.InterfaceDAO;
import dat.DAO.impl.AbstractDAO;
import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
import dat.Route.AbstractRoute;
import dat.Route.InterfaceRoute;
import dat.Service.AbstractService;
import dat.Service.InterfaceService;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class Factory<   Entity  extends AbstractEntity<Entity, ID>,
                        DTO     extends AbstractDTO<DTO,ID>,
                        ID      extends Serializable>
                                extends AbstractFactory<Entity, DTO, ID>
{
    public final EntityManagerFactory    emf;
    public InterfaceController              controller;
    public InterfaceDAO                     dao;
    public InterfaceService                 service;
    public InterfaceRoute routes;

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

    public InterfaceRoute<Entity, DTO, ID> createRoutes()
    {
        this.routes = new AbstractRoute<>(controller, entityClass, dtoClass, idClass) {};
        return routes;
    }
}
