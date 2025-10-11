package dat.routes;

import dat.controllers.InterfaceController;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.factories.AbstractClass;
import dat.services.InterfaceService;
import io.javalin.Javalin;
import lombok.Getter;
import io.javalin.http.Handler;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractRoutes<   Entity  extends     AbstractEntity,
                                        DTO     extends     AbstractDTO,
                                        ID      extends     Serializable>
                                                extends     AbstractClass<  Entity, DTO, ID>
                                                implements  InterfaceRoutes<Entity, DTO, ID>
{
    protected final InterfaceController<Entity, DTO, ID> controller;
    @Getter
    protected ArrayList<Method> routes;

    public AbstractRoutes(InterfaceController<Entity, DTO, ID>  controller,
                          Class<Entity>                         entityClass,
                          Class<DTO>                            dtoClass,
                          Class<ID>                             idClass)
    {
        super(entityClass, dtoClass, idClass);
        this.controller = controller;
        this.routes = new ArrayList<>();
    }

    public abstract void addRoutes(Javalin app, String basePath);

//    public void autoGenerateRoutes(Javalin app, String basePath) {
//        Method[] methods = controller.getClass().getMethods();
//        for (Method method : methods) {
//            // Only process methods that take a single Context parameter
//            if (method.getParameterCount() != 1 || !method.getParameterTypes()[0].equals(io.javalin.http.Context.class)) {
//                continue;
//            }
//            String methodName = method.getName();
//            String fullPath = determineFullPath(basePath, methodName);
//            io.javalin.http.HandlerType httpMethod = determineHttpMethod(methodName);
//            if (httpMethod != null && fullPath != null) {
//                try {
//                    Handler handler = ctx -> method.invoke(controller, ctx);
//                    // Register route based on HTTP method type
//                    switch (httpMethod) {
//                        case GET -> app.get(fullPath, handler);
//                        case POST -> app.post(fullPath, handler);
//                        case PUT -> app.put(fullPath, handler);
//                        case DELETE -> app.delete(fullPath, handler);
//                    }
//                    this.routes.put(fullPath, method);
//                } catch (Exception e) {
//                    throw new RuntimeException("Failed to register route: " + fullPath, e);
//                }
//            }
//        }
//    }

    public void generateRoutes(Javalin app) {
        // Create an Array that contains the methods from my controller class.
        // The controller class that is tied to this Routes class via my (superclass) AbstractClass
        Method[] methods = controller.getClass().getMethods();

        // Iterates through every method in my controller class
        for (Method method : methods) {

            // If a method does not have exactly 1 parameter my for-loop goes to the next entry in my methods array.
            // If the first (and ONLY) parameter does not use the datatype Context my for-loop goes to the next entry in my methods array.
            if (method.getParameterCount() != 1 || !method.getParameterTypes()[0].equals(io.javalin.http.Context.class)) {
                // Goes to the next entry in my methods array with performing any operations
                continue;
            }

                // Since a method satisfies the criteria (only 1 parameter & it must be the datatype javalin.Context)
                routes.add(method);

                //
                io.javalin.http.HandlerType httpMethod = determineHttpMethod(method);

                if (httpMethod != null && getFullPath(method) != null) {
                    try {
                        Handler handler = ctx -> method.invoke(controller, ctx);
                        // Register route based on HTTP method type
                        switch (httpMethod) {
                            case GET -> app.get(getFullPath(method), handler);
                            case POST -> app.post(getFullPath(method), handler);
                            case PUT -> app.put(getFullPath(method), handler);
                            case DELETE -> app.delete(getFullPath(method), handler);
                        }
                        this.routes.add(method);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to register route: " + getFullPath(method), e);
                    }
                }
        }
    }

//    private String determineFullPath(String basePath, String methodName) {
//        /*
//        Returns a unique String based on methods name.
//        This String is used to create a path
//         */
//
//        Method test = null;
//        test.getClass().getSimpleName();
//        Class tezt = test.getClass();
//        return switch (methodName) {
//            case "read", "update", "delete" -> basePath + "/{id}";
//            case "readAll", "create" -> basePath;
//            default -> methodName;
//        };
//    }

    private String getFullPath(Method method){
        /*
        Returns a unique String based on a methods name.
        This String is used to create a path to the Controller.
         */

        // returns the methods name as a String (Java Reflection API)
        return switch(method.getName()){

            // If the method is called 'delete()',
            // the method will return: delete/{Class}/{id}
            case "read", "update", "delete" -> method.getClass().getSimpleName() + "/{id}";

            // If the method is called 'readAll()',
            // the method will return: readAll/{Class}
            case "readAll", "create" -> method.getClass().getSimpleName();

            // returns the class's name as a String (Java Class type token)
            default -> method.getClass().getSimpleName()+"s";
        };
    }

    private io.javalin.http.HandlerType determineHttpMethod(Method method) {
        return switch (method.getName()) {
            case "read", "readAll"  -> io.javalin.http.HandlerType.GET;
            case "create"           -> io.javalin.http.HandlerType.POST;
            case "update"           -> io.javalin.http.HandlerType.PUT;
            case "delete"           -> io.javalin.http.HandlerType.DELETE;
            default -> null;
        };
    }

    protected ArrayList<Method> getAbstractRoutes(){
        return this.routes;
    }

    protected boolean removeRoute(Method method){
        //TODO give this MODERATOR rights ONLY
        return routes.remove(method);
    }
}
