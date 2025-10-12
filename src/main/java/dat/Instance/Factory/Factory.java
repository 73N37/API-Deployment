package dat.Instance.Factory;

import dat.Blueprint.Controller.InterfaceController;
import dat.Blueprint.Controller.AbstractController;
import dat.Blueprint.DAO.InterfaceDAO;
import dat.Blueprint.DAO.AbstractDAO;
import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import dat.Blueprint.Factory.AbstractFactory;
import dat.Blueprint.Route.AbstractRoute;
import dat.Blueprint.Route.InterfaceRoute;
import dat.Blueprint.Service.AbstractService;
import dat.Blueprint.Service.InterfaceService;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;


@Getter
public class Factory<   Entity  extends AbstractEntity<ID>,
                        DTO     extends AbstractDTO<ID>,
                        ID      extends Serializable>
                                extends AbstractFactory<Entity, DTO, ID>
{
    public final EntityManagerFactory       emf;
    public InterfaceController              controller;
    public InterfaceDAO                     dao;
    public InterfaceService                 service;
    public InterfaceRoute                   routes;

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

    public InterfaceDAO<Entity, ID> createDAO(EntityManagerFactory emf)
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
