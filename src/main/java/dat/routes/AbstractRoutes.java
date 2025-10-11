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
    protected Map<String, Method> routes;

    public AbstractRoutes(InterfaceController<Entity, DTO, ID>  controller,
                          Class<Entity>                         entityClass,
                          Class<DTO>                            dtoClass,
                          Class<ID>                             idClass)
    {
        super(entityClass, dtoClass, idClass);
        this.controller = controller;
        this.routes = new TreeMap<>();
    }

    public abstract void addRoutes(Javalin app, String basePath);

    public void autoGenerateRoutes(Javalin app, String basePath) {
        Method[] methods = controller.getClass().getMethods();

        for (Method method : methods) {
            // Only process methods that take a single Context parameter
            if (method.getParameterCount() != 1 ||
                    !method.getParameterTypes()[0].equals(io.javalin.http.Context.class)) {
                continue;
            }

            String methodName = method.getName();
            String fullPath = determineFullPath(basePath, methodName);
            io.javalin.http.HandlerType httpMethod = determineHttpMethod(methodName);

            if (httpMethod != null && fullPath != null) {
                try {
                    Handler handler = ctx -> method.invoke(controller, ctx);
                    // Register route based on HTTP method type
                    switch (httpMethod) {
                        case GET -> app.get(fullPath, handler);
                        case POST -> app.post(fullPath, handler);
                        case PUT -> app.put(fullPath, handler);
                        case DELETE -> app.delete(fullPath, handler);
                    }
                    this.routes.put(fullPath, method);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to register route: " + fullPath, e);
                }
            }
        }
    }

    private String determineFullPath(String basePath, String methodName) {
        return switch (methodName) {
            case "read", "update", "delete" -> basePath + "/{id}";
            case "readAll", "create" -> basePath;
            default -> null;
        };
    }

    private io.javalin.http.HandlerType determineHttpMethod(String methodName) {
        return switch (methodName) {
            case "read", "readAll" -> io.javalin.http.HandlerType.GET;
            case "create" -> io.javalin.http.HandlerType.POST;
            case "update" -> io.javalin.http.HandlerType.PUT;
            case "delete" -> io.javalin.http.HandlerType.DELETE;
            default -> null;
        };
    }

    protected Map<String, Method> getAbstractRoutes(){
        return this.routes;
    }

    protected boolean removeRoute(String routeName){
        //TODO give this MODERATOR rights ONLY
        for (Map.Entry<String, Method> routes : routes.entrySet()){
            String pathName = routes.getKey();
            if(pathName.equals(routeName)){
                this.routes.remove(routeName);
                return true;
            }
        }
        return false;
    }
}
