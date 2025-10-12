package dat.Controller;

import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
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
}