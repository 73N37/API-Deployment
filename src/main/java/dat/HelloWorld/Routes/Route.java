package dat.HelloWorld.Routes;

import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Route {
    private final HelloWorldRoute helloRoute = new HelloWorldRoute();

    public EndpointGroup getRoutes()
    {
        return () -> {
            path("/test", helloRoute.getRoutes());
        };
    }
}
