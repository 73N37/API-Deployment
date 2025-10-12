package dat.Blueprint.Route;

import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import io.javalin.Javalin;

import java.io.Serializable;

public interface InterfaceRoute<   Entity  extends AbstractEntity,
                                    DTO     extends AbstractDTO,
                                    ID      extends Serializable>
{

    void generateRoutes(Javalin app);
}
