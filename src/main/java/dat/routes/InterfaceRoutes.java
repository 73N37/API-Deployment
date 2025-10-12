package dat.routes;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import io.javalin.Javalin;

import java.io.Serializable;

public interface InterfaceRoutes<   Entity  extends AbstractEntity,
                                    DTO     extends AbstractDTO,
                                    ID      extends Serializable>
{

    void generateRoutes(Javalin app);
}
