package dat.TestPackage;

// The name I have chosen is: UTILIZE the RELATION between INFORMATION and OPERATIONS = U-R-O-I

public class TestUtilization
{   // TestUtilization [class] begins
// TODO     Fields:
//          These Fields are accessible to Information.class & Operation.class
    protected static final jakarta.persistence.EntityManagerFactory emf = dat.Config.HibernateConfig.createEMF(false);  // I changed this to be created on instantiation of this class. So that I do not need to pass it around all the time.


    protected enum
    Role implements io.javalin.security.RouteRole
    {   // Role [enum] begins
        ANYONE(0),      // Lowest access-level
        USER(1),        // Second lowest access-level
        ADMIN(2),       // Second highest access-level
        MODERATOR(3);   // Highest access-level

        protected final int roleCode;
        Role(int roleCode)
        {   // Role(int) [constructor] begins
            this.roleCode = roleCode;
        }   // Role(int) [constructor] ends


        protected int
        get()
        {
            return this.roleCode;
        }

        protected boolean
        isAccessAllowed
                (       // Arguments begins
                        int                                     accessCode,
                        dat.TestPackage.TestUtilization.Role    role
                )       // Arguments ends
        {   // isAccessAllowed(int, Role) [method] begins
// TODO     If a user has a 'roleCode' HIGHER or EQUAL to 'accessCode'. This method will return true.
// TODO     If a user has a 'roleCode' BELOW the 'accessCode'. This method will return false;
            return (role.get() >= accessCode) ?  true : false;
        }   // isAccessAllowed(int, role) [method] ends




        protected boolean
        isAccessAllowed
                (       // Arguments begins
                        dat.TestPackage.TestUtilization.Role minimumAccess,
                        dat.TestPackage.TestUtilization.Role attemptedAccess
                )       // Arguments ends
        {   // isAccessAllowed(Role, Role) [method] begins
// TODO     If a user has a 'roleCode' HIGHER or EQUAL to 'accessCode'. This method will return true.
// TODO     If a user has a 'roleCode' BELOW the 'accessCode'. This method will return false;
            return isAccessAllowed(minimumAccess.get(), attemptedAccess);
        }   // isAccessAllowed(Role, Role) [method] ends
    }   // Role [enum] ends
}   // TestUtilization [class] ends
