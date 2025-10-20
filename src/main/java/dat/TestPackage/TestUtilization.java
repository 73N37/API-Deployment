package dat.TestPackage;

public class TestUtilization {
    protected static final jakarta.persistence.EntityManagerFactory                     emf = dat.Config.HibernateConfig.createEMF(false);  // I changed this to be created on instantiation of this class. So that I do not need to pass it around all the time.


    protected enum
    Role implements io.javalin.security.RouteRole
    {
        ANYONE,
        USER,
        ADMIN,
        MODERATOR;
    }
}
