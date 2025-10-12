package dat.Blueprint.Route;

import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import io.javalin.Javalin;

import java.io.Serializable;

public interface InterfaceRoute
{

    void generateRoutes(Javalin app);
}
