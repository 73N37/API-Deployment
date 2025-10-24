package dat.HelloWorld.DAOs;

import dat.HelloWorld.HelloWorldDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class HelloWorldDAO
{
    private static HelloWorldDAO instance;
    private static EntityManagerFactory emf;
    private HelloWorldDAO(){}

    public static HelloWorldDAO getInstance(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf         =   _emf;
            instance    =   new HelloWorldDAO();
        }
        return instance;
    }

    public HelloWorldDTO createDTO(String message)
    {
        return new HelloWorldDTO(message);
    }
}
