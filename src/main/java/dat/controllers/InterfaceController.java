package dat.controllers;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import io.javalin.http.Context;

public interface InterfaceController<   DTO extends AbstractDTO,
                                        Entity extends AbstractEntity,
                                        ID extends Object> {
    void read(Context ctx);
    void readAll(Context ctx);
    void create(Context ctx);
    void update(Context ctx);
    void delete(Context ctx);
    boolean validatePrimaryKey(ID id);
    DTO validateEntity(Context ctx);
}
