package dat.Package;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InformationTest {

    dat.Package.Utilization.Role any = dat.Package.Utilization.Role.ANYONE;
    dat.Package.Utilization.Role user = dat.Package.Utilization.Role.USER;
    dat.Package.Utilization.Role adm = dat.Package.Utilization.Role.ADMIN;
    dat.Package.Utilization.Role mod = dat.Package.Utilization.Role.MODERATOR;

    @BeforeEach
    void setUp()
    {
        //new Information.Data().clearGlobalState();
    }



    @Test
    @Order(1)
    void ANY_ANY()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ANYONE.get(),
                        dat.Package.Utilization.Role.ANYONE.get()),
                true);
    }

    @Test
    @Order(2)
    void ANY_USER()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ANYONE.get(),
                        dat.Package.Utilization.Role.USER.get()),
                false);
    }

    @Test
    @Order(3)
    void ANY_ADMIN()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ANYONE.get(),
                        dat.Package.Utilization.Role.ADMIN.get()),
                false);
    }

    @Order(4)
    @Test
    void ANY_MODERATOR()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ANYONE.get(),
                        dat.Package.Utilization.Role.MODERATOR.get()),
                false);
    }

    @Test
    @Order(5)
    void USER_ANY()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.MODERATOR.get(),
                        dat.Package.Utilization.Role.ANYONE.get()),
                true);
    }

    @Test
    @Order(6)
    void USER_USER()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.USER.get(),
                        dat.Package.Utilization.Role.USER.get()),
                true);
    }

    @Test
    @Order(7)
    void USER_ADMIN()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.USER.get(),
                        dat.Package.Utilization.Role.ADMIN.get()),
                false);
    }

    @Test
    @Order(8)
    void USER_MOD()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.USER.get(),
                        dat.Package.Utilization.Role.MODERATOR.get()),
                false);
    }

    @Test
    @Order(9)
    void ADMIN_ANYONE()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ADMIN.get(),
                        dat.Package.Utilization.Role.ANYONE.get()),
                true);
    }

    @Test
    @Order(10)
    void ADMIN_USER()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ADMIN.get(),
                        dat.Package.Utilization.Role.USER.get()),
                true);
    }

    @Test
    @Order(11)
    void ADMIN_ADMIN()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ADMIN.get(),
                        dat.Package.Utilization.Role.ADMIN.get()),
                true);
    }

    @Test
    @Order(12)
    void ADMIN_MOD()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.ADMIN.get(),
                        dat.Package.Utilization.Role.MODERATOR.get()),
                false);
    }

    @Test
    @Order(13)
    void MOD_ANYONE()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.MODERATOR.get(),
                        dat.Package.Utilization.Role.ANYONE.get()),
                true);
    }

    @Test
    @Order(14)
    void MOD_USER()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.MODERATOR.get(),
                        dat.Package.Utilization.Role.USER.get()),
                true);
    }

    @Test
    @Order(15)
    void MOD_ADMIN()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.MODERATOR.get(),
                        dat.Package.Utilization.Role.ADMIN.get()),
                true);

    }

    @Test
    @Order(16)
    void MOD_MOD()
    {
        assertEquals(   dat.Package.Utilization.Role.isAccessAllowed(
                        dat.Package.Utilization.Role.MODERATOR.get(),
                        dat.Package.Utilization.Role.MODERATOR.get()),
                true);
    }

    @Test
    @Order(17)
    void getInstanceANY()
    {
        var info1 = new Information.Data().getInstance(any);
        var info2 = new Information.Data().getInstance(user);
        assertTrue(info1.equals(info2));
    }

    @Test
    @Order(18)
    void getInstanceUSER()
    {
        var info1 = new Information.Data().getInstance(user);
        var info2 = new Information.Data().getInstance(adm);
        assertTrue(info1.equals(info2));
    }

    @Test
    @Order(19)
    void getInstanceADMIN()
    {
        var info1 = new Information.Data().getInstance(adm);
        var info2 = new Information.Data().getInstance(mod);
        assertTrue(info1.equals(info2));
    }


    @Test
    @Order(20)
    void getInstanceMOD()
    {
        var info1 = new Information.Data().getInstance(mod);
        var info2 = new Information.Data().getInstance(mod);
        assertTrue(info1.equals(info2));
    }

    @Test
    @Order(21)
    void putEntityANY()
    {
        var entity = new Information.Data().put("Merovingian", any);
        assertNull(entity);
    }

    @Test
    @Order(22)
    void putEntityUSER()
    {
        var entity = new Information.Data().put("Merovingian", user);
        assertEquals(entity, new Information.Data().get(1,user));
    }

    @Test
    @Order(23)
    void putEntityADMIN()
    {
        var entity = new Information.Data().put("Merovingian", adm);
        assertNotNull(entity);
    }

    @Test
    @Order(24)
    void putEntityMOD()
    {
        var test = new Information.Data().put("Merovingian", mod);
        assertNotNull(new Information.Data().getId(test));
        assertNotNull(new Information.Data().getName(test));
    }

    @Test
    @Order(25)
    void getEntityANY()
    {
        var entity = new Information.Data().get(1, any);
        assertNull(entity);
    }

    @Test
    @Order(26)
    void getEntityUSER()
    {
        var test = new Information.Data().put("Merovingian", user);
        assertNotNull(new Information.Data().get(new dat.Package.Information.Data().getId(test), user));
    }

    @Test
    @Order(27)
    void getEntityADMIN()
    {
        var test = new Information.Data().put("Merovingian", adm);
        assertNotNull(new Information.Data().get(new dat.Package.Information.Data().getId(test), adm));
    }

    @Test
    @Order(28)
    void getEntityMOD()
    {
        var test = new Information.Data().put("Merovingian", mod);
        assertNotNull(new Information.Data().get(new dat.Package.Information.Data().getId(test),mod));
    }

    @Test
    @Order(29)
    void deleteEntityNoIdANY()
    {
        dat.Package.Utilization.Role any = dat.Package.Utilization.Role.ANYONE;
        assertThrows(Exception.class, () -> {
            var deleteMe = new Information.Data().put("Merovingian", this.any);
            new Information.Data().delete(deleteMe, this.any);
        });
    }

    @Test
    @Order(30)
    void deleteEntityNoIdUser()
    {
        var successfulCreation = new Information.Data().put("Merovingian", user);
        new Information.Data().delete(successfulCreation, user);
    }

    @Test
    @Order(31)
    void deleteEntityNoIdAdmin()
    {
        var successfulCreation = new Information.Data().put("Merovingian", adm);
        new Information.Data().delete(successfulCreation, adm);
    }


    @Test
    @Order(32)
    void deleteEntityNoIdMod()
    {
        var successfulCreation = new Information.Data().put("Merovingian", mod);
        new Information.Data().delete(successfulCreation, mod);
    }
}