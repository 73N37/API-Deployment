package dat.factories;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.routes.InterfaceRoutes;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class AbstractClass< Entity  extends     AbstractEntity,
                            DTO     extends     AbstractDTO,
                            ID      extends     Serializable>
{
    protected final Class<Entity>   entityClass;
    protected final Class<DTO>      dtoClass;
    protected final Class<ID>       idClass;

    protected AbstractClass(Class<Entity>   entity,
                            Class<DTO>      dto,
                            Class<ID>       id)
    {
        this.entityClass =  entity;
        this.dtoClass =     dto;
        this.idClass =      id;
    }

    protected ID parseId(String idString) {
        try {
            return idClass.cast(
                    idClass
                            .getMethod("valueOf", String.class)
                            .invoke(null, idString)
            );
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot parse ID: " + idString, e);
        }
    }
}
