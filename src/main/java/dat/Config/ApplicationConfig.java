package dat.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat.Instance.Factory.Factory;
import dat.Blueprint.Route.InterfaceRoute;
import dat.Security.controllers.AccessController;
import dat.Security.controllers.SecurityController;
import dat.Security.enums.Role;
import dat.Security.exceptions.ApiException;
import dat.Security.routes.SecurityRoutes;
import dat.Utils.Utils;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class ApplicationConfig {

    private static final List<InterfaceRoute> routesList = new ArrayList<>();
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

    public static void registerRoutes(Javalin app, Factory<?,?,?> factory){
        factory.getRoutes().generateRoutes(app);
    }

    public Javalin startServer(int port) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);

            // Register all routes - FIXED
//        for (InterfaceRoutes<? extends Entity, ? extends DTO, ? extends ID> route : routesList) {
//            if (route instanceof AbstractRoutes<? extends Entity, ? extends DTO, ? extends ID> abstractRoute) {
//                abstractRoute.generateRoutes(app);
//            }
//        }

        // Register all routes
        for (InterfaceRoute route : routesList) {
            route.generateRoutes(app);
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
