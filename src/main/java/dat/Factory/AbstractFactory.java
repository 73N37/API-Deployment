package dat.Factory;

import dat.Controller.InterfaceController;
import dat.DAO.InterfaceDAO;
import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
import dat.Route.InterfaceRoute;
import dat.Service.InterfaceService;
import dat.Unit.AbstractUnit;
import lombok.Getter;
import java.io.Serializable;

@Getter
public  class AbstractFactory<  Entity  extends     AbstractEntity,
                                DTO     extends     AbstractDTO,
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


}
