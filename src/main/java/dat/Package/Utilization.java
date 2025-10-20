package dat.Package;

// The name I have chosen is: UTILIZE the RELATION between INFORMATION and OPERATIONS = U-R-O-I

public class Utilization
{   // TestUtilization [class] begins
    protected static final jakarta.persistence.EntityManagerFactory emf = dat.Config.HibernateConfig.createEMF(false);

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
                (   // Arguments [method] begins
                        int                                 attemptedAccess,
                        dat.Package.Utilization.Role        role
                )   // Arguments [method] ends
        {   // isAccessAllowed(int, Role) [method] begins
// TODO     If user has a 'roleCode' HIGHER or EQUAL to 'accessCode'. This method will return true.
// TODO     Id user has a 'roleCode' LOWER than 'accessCode'. This method will return false.
            return isAccessAllowed(attemptedAccess, role.get());
        }   // isAccessAllowed(int, role) [method] ends


        protected static boolean
        isAccessAllowed
                (   // Arguments [method] begins
                        dat.Package.Utilization.Role    attemptedAccess,
                        dat.Package.Utilization.Role    requiredAccess
                )   // Arguments [method] ends
        {   // isAccessAllowed(Role, Role) [method] begins
// TODO     If user has a 'roleCode' HIGHER or EQUAL to 'accessCode'. This method will return true.
// TODO     Id user has a 'roleCode' LOWER than 'accessCode'. This method will return false.
            return isAccessAllowed(attemptedAccess.get(), requiredAccess.get());
        }   // isAccessAllowed(Role, role) [method] ends

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
