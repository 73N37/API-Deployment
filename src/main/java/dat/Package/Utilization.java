package dat.Package;

// The name I have chosen is: UTILIZE the RELATION between INFORMATION and OPERATIONS = U-R-O-I

public abstract class Utilization
{   // TestUtilization [class] begins

    protected static final java.lang.Class operation = dat.Package.Operation.class;
    protected static final java.lang.Class information = dat.Package.Information.class;

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
