package dat.factories;

import dat.controllers.InterfaceController;
import dat.controllers.impl.AbstractController;
import dat.daos.InterfaceDAO;
import dat.daos.impl.AbstractDAO;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.services.AbstractService;
import dat.services.InterfaceService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class Singularity<   Entity  extends AbstractEntity<Entity, ID>,
                            DTO     extends AbstractDTO<DTO,ID>,
                            ID      extends Serializable>
{
    private final Class<Entity>     entityClass;
    private final Class<DTO>        dtoClass;
    private final Class<ID>         idClass;
    private EntityManagerFactory    emf;
    private InterfaceController     controller;
    private InterfaceDAO            dao;
    private InterfaceService        service;
    private InterfaceRoutes         routes;

    public Singularity(Class<Entity>        entityClass,
                       Class<DTO>           dtoClass,
                       Class<ID>            idClass,
                       EntityManagerFactory emf)
    {
        this.entityClass =  entityClass;
        this.dtoClass =     dtoClass;
        this.idClass =      idClass;
        this.emf = emf;
    }

    public void create(){
        createDAO();
        createService();
        createController();
        createRoutes();
    }

    public InterfaceDAO<Entity, DTO, ID> createDAO()
    {
        this.dao = new AbstractDAO<Entity, DTO, ID>(emf, entityClass, dtoClass, idClass) {};
        return dao;
    }

    public InterfaceService<Entity, DTO, ID> createService()
    {
        this.service = new AbstractService<Entity, DTO, ID>(dao, entityClass, dtoClass, idClass) {};
        return service;
    }

    public InterfaceController<Entity, DTO, ID> createController()
    {
        this.controller = new AbstractController<Entity, DTO, ID>(service, entityClass, dtoClass, idClass) {};
        return controller;
    }

    public InterfaceRoute<Entity, DTO, ID> createRoutes()
    {
        this.route = new AbstractRoutes<Entity, DTO, ID>(controller, entityClass, dtoClass, idClass);
        return routes;
    }
}
