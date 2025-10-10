package dat.controllers;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import io.javalin.http.Context;

import java.io.Serializable;

public interface InterfaceController<   Entity  extends AbstractEntity,
                                        DTO     extends AbstractDTO,
                                        ID      extends Serializable>
{
    void read(Context ctx);
    void readAll(Context ctx);
    void create(Context ctx);
    void update(Context ctx);
    void delete(Context ctx);
    boolean validatePrimaryKey(Context ctx);
    DTO validateEntity(Context ctx);
}
