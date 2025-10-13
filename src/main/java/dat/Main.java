package dat;
import dat.Config.ApplicationConfig;
import dat.Config.HibernateConfig;
import dat.TestPackage.TestData;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main
{ // TODO Please read the book!!! We had a deal...
    public static void main(String[] args) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);
        EntityManagerFactory emf = HibernateConfig.createEMF(false);
//
//        Factory<Hotel, HotelDTO, Integer> hotelFactory = new Factory( Hotel.class, HotelDTO.class, Integer.class, emf);
//        Factory<Room, RoomDTO, Integer> roomFactory = new Factory( Room.class, RoomDTO.class, Integer.class, emf);
//        hotelFactory.create();
//        roomFactory.create();
//        ApplicationConfig.registerRoutes(app, hotelFactory);
//        ApplicationConfig.registerRoutes(app, roomFactory);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
            emf.close();
        }));

        app.start(7070);

        System.out.println("Entity Data = " + dat.TestPackage.TestData.Methods.constructor(dat.TestPackage.TestData.DataType.RECORD, "I never give up"));
        System.out.println("Record Data = " + dat.TestPackage.TestData.Methods.constructor(dat.TestPackage.TestData.DataType.ENTITY, "I must excel"));
        System.out.println("=== MAIN IS COMPLETE ===");
    }
}