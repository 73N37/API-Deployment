package dat.Controller;

import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
import io.javalin.http.Handler;
import java.io.Serializable;

public interface InterfaceController<   Entity  extends AbstractEntity,
                                        DTO     extends AbstractDTO,
                                        ID      extends Serializable>
{
    Handler get();
    Handler getAll();
    Handler post();
    Handler put();
    Handler delete();
}