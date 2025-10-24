package dat.HelloWorld.Controllers;


import dat.Config.HibernateConfig;
import dat.HelloWorld.DAOs.HelloWorldDAO;
import dat.HelloWorld.HelloWorldDTO;
import io.javalin.http.Context;
import jakarta.persistence.EntityManagerFactory;

public class HelloWorldController
{
    private HelloWorldDAO dao;

    public HelloWorldController()
    {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = HelloWorldDAO.getInstance(emf);
    }

    public void helloWorld(Context ctx)
    {
        HelloWorldDTO message = dao.createDTO("Hello World");
        ctx.res().setStatus(200);
        ctx.json(message, HelloWorldDTO.class);
    }
}
