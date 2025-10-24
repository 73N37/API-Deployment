package dat.HelloWorld.Routes;

import dat.HelloWorld.Controllers.HelloWorldController;
import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;

public class HelloWorldRoute
{
    private final HelloWorldController controller = new HelloWorldController();

    public EndpointGroup getRoutes()
    {
        return () -> {
            get("/test1", controller::helloWorld);
        };
    }
}
