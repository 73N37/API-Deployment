package dat.Blueprint.Factory;
import dat.Blueprint.Controller.InterfaceController;
import dat.Blueprint.DAO.InterfaceDAO;
import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import dat.Blueprint.Route.InterfaceRoute;
import dat.Blueprint.Service.InterfaceService;
import dat.Blueprint.Unit.AbstractUnit;
import io.javalin.http.Handler;
import lombok.Getter;
import java.io.Serializable;

@Getter
public abstract  class AbstractFactory<     Entity  extends     dat.Instance.Entity.Entity,
                                            DTO     extends     dat.Instance.DTO.DTO,
                                            ID      extends     Serializable>
                                                    extends     AbstractUnit
{
    public Class<Entity>         entityClass;
    public Class<DTO>            dtoClass;
    public Class<ID>             idClass;
    public InterfaceController   controller;
    public InterfaceDAO          dao;
    public InterfaceService      service;
    public InterfaceRoute        routes;
    
    public AbstractFactory( Class<Entity>   entityClass,
                            Class<DTO>      dtoClass,
                            Class<ID>       idClass)
    {
        this.entityClass =  entityClass;
        this.dtoClass =     dtoClass;
        this.idClass =      idClass;
    }

    public ID parseId(String idString)
    {
        try {
            return idClass.cast(idClass.getMethod("valueOf", String.class).invoke(null, idString));
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot parse ID: " + idString, e);
        }
    }

    @Override
    public ID getIdentifier()
    {
        return parseId(entityClass.getSimpleName() + "Factory");
    }

    public Handler getAll()
    {

        return controller.getAll();
    }

    public Handler get(){
        return controller.get();
    }

    public Handler put(){
        return controller.put();
    }

    public Handler post(){
        return controller.post();
    }

    public Handler delete(){
        return controller.delete();
    }
}
