package dat.Blueprint.Route;

import dat.Annotation.RouteHandler;
import dat.Blueprint.Controller.InterfaceController;
import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import dat.Blueprint.Factory.AbstractFactory;
import io.javalin.*;
import io.javalin.apibuilder.ApiBuilder;
import lombok.Getter;
import io.javalin.http.Handler;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

import static io.javalin.apibuilder.ApiBuilder.*;

public abstract class AbstractRoute<   Entity  extends     dat.Instance.Entity.Entity,
                                        DTO     extends     dat.Instance.DTO.DTO,
                                        ID      extends     Serializable>
                                                extends AbstractFactory<  Entity, DTO, ID>
                                                implements InterfaceRoute
{
    public final InterfaceController<Entity, DTO, ID> controller;
    @Getter
    public Set<Method> methodSet;

    public AbstractRoute(InterfaceController<Entity, DTO, ID>  controller,
                         Class<Entity>                         entityClass,
                         Class<DTO>                            dtoClass,
                         Class<ID>                             idClass)
    {
        super(entityClass, dtoClass, idClass);
        this.controller = controller;
        this.methodSet = new HashSet<>();
    }

    @Override
    public void generateRoutes(Javalin app)
    {   log.info("Generating routes for {}", entityClass.getSimpleName().toLowerCase());
        // Create an Array that contains the methods from my controller class.
        // The controller class that is tied to this Routes class via my (superclass) AbstractFactory
//        Method[] methods = controller.getClass().getMethods();
//
//        // Iterates through every method in my controller class
//        for (Method method : methods) {
//
//            // If a method does not have exactly 1 parameter my for-loop goes to the next entry in my methods array.
//            // If the first (and ONLY) parameter does not use the datatype Context my for-loop goes to the next entry in my methods array.
//            if (method.getParameterCount() != 1 || !method.getParameterTypes()[0].equals(io.javalin.http.Context.class)) {
//                // Goes to the next entry in my methods array with performing any operations
//                continue;
//            }
//
//                // Determines what Enum (HandlerType) a given method must be
//                io.javalin.http.HandlerType httpMethod = determineHttpMethod(method);
//
//                // Makes sure that httpMethod isn't invalid
//                if (httpMethod != null && getFullPath(method) != null) {
//                    try {
//
//                        /*
//                         You don't know at compile-time which specific controller method will be called. (Java reflection API)
//                         The method is determined dynamically at runtime. The method is determined by how far in the methods array (line 68) you have come
//                         */
//                        Handler handler = ctx -> method.invoke(controller, ctx);
//
//                        // Register route based on HTTP method type
//                        switch (httpMethod) {
//                            case GET    -> app.get(     getFullPath(method), handler);
//                            case POST   -> app.post(    getFullPath(method), handler);
//                            case PUT    -> app.put(     getFullPath(method), handler);
//                            case DELETE -> app.delete(  getFullPath(method), handler);
//                        }
//
//                        // Since a method satisfies the criteria (only 1 parameter & it must be the datatype javalin.Context)
//                        methodSet.add(method);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Failed to register route: " + getFullPath(method), e);
//                    }
//                }
//        }

        String basePath = "/" + entityClass.getSimpleName().toLowerCase()+"s";
        log.info("Base path: {}", basePath);
        // Use Javalin app directly to create paths for my API
        app.get(basePath+"/{id}", controller.get());        // endpoint: GET {domain}/api/{className}s/{id}
        log.info("Route generated: GET {}/{id}", basePath);

        app.get(basePath, controller.getAll());                  // endpoint: GET {domain}/api/{className}s
        log.info("Route generated: GET {}", basePath);

        app.post(basePath, controller.post());                  // endpoint: POST {domain}/api/{className}
        log.info("Route generated: POST {}/{dto.json}", basePath);

        app.put(basePath, controller.put());                    // endpoint: PUT  {domain}/api/{className}
        log.info("Route generated: PUT {}/{dto.json}", basePath);

        app.delete(basePath, controller.delete());
        log.info("Route generated: DELETE {}/{id}", basePath);  // endpoint: DELETE {domain}/api/{className}/{id}

        log.info("Completed route generation for {}", entityClass.getSimpleName());
    }

    private String getFullPath(Method method){
        /*
        Returns a unique String based on a methods name.
        This String is used to create a path to the Controller.
         */

        // returns the Class's name as a String (Java Reflection API)
        String path = "/api/" + entityClass.getSimpleName().toLowerCase() + "s";
        return switch(method.getName())
        {
            // If the method is called 'delete()',
            // the method will return: delete/{Class}/{id}
            case "read", "update", "delete" -> path + "/{id}";

            // If the method is called 'readAll()',
            // the method will return: readAll/{Class}
            case "readAll", "create" -> path;

            // returns the class's name as a String (Java Class type token)
            default -> path;
        };
    }

    private io.javalin.http.HandlerType determineHttpMethod(Method method) {
        RouteHandler annotation = method.getAnnotation(RouteHandler.class);
        if (annotation != null) {
            return annotation.value();
        }
        // The switch case is a fail-safe in case I forgot to use the RouteHandler annotation in my controller
        return switch (method.getName()) {
            case "read", "readAll"  -> io.javalin.http.HandlerType.GET;
            case "create"           -> io.javalin.http.HandlerType.POST;
            case "update"           -> io.javalin.http.HandlerType.PUT;
            case "delete"           -> io.javalin.http.HandlerType.DELETE;
            // Will only return null if I mistyped the method name
            default -> null;
        };
    }

    public boolean removeRoute(Method method) {
        //TODO give this MODERATOR rights ONLY
        return methodSet.remove(method);
    }
}
