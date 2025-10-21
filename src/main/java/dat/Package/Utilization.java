package dat.Package;

// The name I have chosen is: UTILIZE the RELATION between INFORMATION and OPERATIONS = U-R-O-I

public class Utilization
{   // TestUtilization [class] begins

    protected Utilization(){}
    protected static Utilization instance;

    protected static dat.Package.Utilization            operationInstance       =   new dat.Package.TestOperation().getInstance();
    protected static Class<?>                           operationClass          =   new dat.Package.TestInformation().getClass();
    protected static dat.Package.Operation.DAO          dao                     =   new dat.Package.Operation.Factory().getDAO();
    protected static dat.Package.Operation.Service      service                 =   new dat.Package.Operation.Factory().getService();
    protected static dat.Package.Operation.Controller   controller              =   new dat.Package.Operation.Factory().getController();
    protected static dat.Package.Operation.Route        route                   =   new dat.Package.Operation.Factory().getRoute();


    // TODO Use TestInformation as the class
    protected static dat.Package.Utilization        informationInstance     =   new dat.Package.TestInformation().getInstance();
    protected static Class<?>                       informationClass        =   new dat.Package.TestInformation().getClass();


    protected static dat.Package.Utilization getInstance()
    {
        if (instance == null){
            return new Utilization();
        }
        return instance;
    }



    protected enum
    Role implements io.javalin.security.RouteRole
    {   // Role [enum] begins
        ANYONE(0),
        USER(1),
        ADMIN(2),
        MODERATOR(3);

        protected final int roleCode;
        Role(int roleCode){
            this.roleCode = roleCode;
        }


        protected int
        get()
        {
            return this.roleCode;
        }


        protected static boolean
        isAccessAllowed
                (    // Arguments [method] begins
                     int attemptedAccess,
                     int requiredAccess
                )   // Arguments [method] ends
        {   // isAccessAllowed(int, int) [method] ends
// TODO     If user has a 'roleCode' HIGHER or EQUAL to 'accessCode'. This method will return true.
// TODO     Id user has a 'roleCode' LOWER than 'accessCode'. This method will return false.
            return (attemptedAccess >= requiredAccess) ? true : false;
        }   // isAccessAllowed(int, int) [method] ends
    }   // Role [enum] ends
}   // TestUtilization [class] ends
