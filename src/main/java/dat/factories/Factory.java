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
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class Singularity<   Entity  extends AbstractEntity<Entity, ID>,
                            DTO     extends AbstractDTO<DTO,ID>,
                            ID      extends Serializable>
{
    protected final Class<Entity>   entityClass;
    protected final Class<DTO>      dtoClass;
    protected final Class<ID>       idClass;
    protected EntityManagerFactory  emf;
    public InterfaceController      controller;
    public InterfaceDAO             dao;
    public InterfaceService         service;
    public InterfaceRoutes          routes;

    public Singularity(Class<Entity>        entityClass,
                       Class<DTO>           dtoClass,
                       Class<ID>            idClass,
                       EntityManagerFactory emf)
    {
        this.entityClass =  entityClass;
        this.dtoClass =     dtoClass;
        this.idClass =      idClass;
        this.emf =          emf;
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
        this.routes = new AbstractRoutes<>(controller, entityClass, dtoClass, idClass) {
            @Override
            public void addRoutes(Javalin app, String basePath) {

            }
        };
        return routes;
    }
}
