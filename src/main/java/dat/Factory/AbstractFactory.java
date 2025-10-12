package dat.Factories;

import dat.Controllers.InterfaceController;
import dat.DAOs.InterfaceDAO;
import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;
import dat.Routes.InterfaceRoutes;
import dat.Services.InterfaceService;
import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class AbstractFactory<  Entity  extends   AbstractEntity,
                                        DTO     extends     AbstractDTO,
                                        ID      extends     Serializable>
{
    protected final Class<Entity>   entityClass;
    protected final Class<DTO>      dtoClass;
    protected final Class<ID>       idClass;
    protected  InterfaceController  controller;
    protected  InterfaceDAO         dao;
    protected  InterfaceService     service;
    protected  InterfaceRoutes      routes;

    protected AbstractFactory(Class<Entity>   entityClass,
                              Class<DTO>      dtoClass,
                              Class<ID>       idClass)
    {
        this.entityClass =  entityClass;
        this.dtoClass =     dtoClass;
        this.idClass =      idClass;
    }

    AbstractFactory<Entity, DTO, ID> getThis(){
        return this;
    }

    protected ID parseId(String idString)
    {
        try {
            return idClass.cast(idClass.getMethod("valueOf", String.class).invoke(null, idString));
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot parse ID: " + idString, e);
        }
    }
}
