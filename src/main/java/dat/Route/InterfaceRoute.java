package dat.Route;

import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
import io.javalin.Javalin;

import java.io.Serializable;

public interface InterfaceRoute<   Entity  extends AbstractEntity,
                                    DTO     extends AbstractDTO,
                                    ID      extends Serializable>
{

    void generateRoutes(Javalin app);
}
