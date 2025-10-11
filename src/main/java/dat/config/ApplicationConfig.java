package dat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.routes.AbstractRoutes;
import dat.security.controllers.AccessController;
import dat.security.controllers.SecurityController;
import dat.security.enums.Role;
import dat.security.exceptions.ApiException;
import dat.security.routes.SecurityRoutes;
import dat.utils.Utils;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ApplicationConfig< Entity  extends AbstractEntity,
                                DTO     extends AbstractDTO,
                                ID      extends Serializable> {

    private final List<AbstractRoutes<Entity, DTO, ID>> routesList = new ArrayList<>();
    private static final ObjectMapper jsonMapper = new Utils().getObjectMapper();
    private static final SecurityController securityController = SecurityController.getInstance();
    private static final AccessController accessController = new AccessController();
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
    private static int count = 1;

    public static void configuration(JavalinConfig config) {
        config.showJavalinBanner = false;
        config.bundledPlugins.enableRouteOverview("/routes", Role.ANYONE);
        config.router.contextPath = "/api"; // base path for all endpoints
        config.router.apiBuilder(SecurityRoutes.getSecuredRoutes());
        config.router.apiBuilder(SecurityRoutes.getSecurityRoutes());
    }

    public Javalin startServer(int port) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);

        // Register all routes
        for (AbstractRoutes<Entity, DTO, ID> routes : this.routesList) {
            routes.generateRoutes(app);
        }
        
        app.beforeMatched(accessController::accessHandler);
        app.after(ApplicationConfig::afterRequest);

        app.exception(Exception.class, ApplicationConfig::generalExceptionHandler);
        app.exception(ApiException.class, ApplicationConfig::apiExceptionHandler);
        app.start(port);
        return app;
    }
    
    public static void afterRequest(Context ctx) {
        String requestInfo = ctx.req().getMethod() + " " + ctx.req().getRequestURI();
        log.info(" Request {} - {} was handled with status code {}", count++, requestInfo, ctx.status());
    }

    public void stopServer(Javalin app) {
        // TODO give MODERATOR access ONLY
        app.stop();
    }

    private static void generalExceptionHandler(Exception e, Context ctx) {
        log.error("An unhandled exception occurred\n", e.getMessage());
        ctx.json(Utils.convertToJsonMessage(ctx, "error", e.getMessage()));
    }

    public static void apiExceptionHandler(ApiException e, Context ctx) {
        ctx.status(e.getCode());
        log.warn("An API exception occurred: Code: {}, Message: {}", e.getCode(), e.getMessage());
        ctx.json(Utils.convertToJsonMessage(ctx, "warning", e.getMessage()));
    }
}
