package dat;
import dat.Config.ApplicationConfig;
import dat.Config.HibernateConfig;
import dat.Instance.DTO.HotelDTO;
import dat.Instance.DTO.RoomDTO;
import dat.TestPackage.TestBlueprint.TestDTO.TestHotelDTO;
import dat.Instance.Entity.Hotel;
import dat.Instance.Entity.Room;
import dat.TestPackage.TestBlueprint.TestEntity.TestHotel;
import dat.Instance.Factory.Factory;
import dat.TestPackage.TestBlueprint.TestFactory.TestFactory;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main
{ // TODO Please read the book!!! We had a deal...
    public static void main(String[] args) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);
        EntityManagerFactory emf = HibernateConfig.createEMF(false);

        TestFactory<TestHotel, TestHotelDTO, Integer> abstractHotelFactory = new TestFactory(TestHotel.class, TestHotelDTO.class, Integer.class, emf);
        Factory<Hotel, HotelDTO, Integer> hotelFactory = new Factory( Hotel.class, HotelDTO.class, Integer.class, emf);
        Factory<Room, RoomDTO, Integer> roomFactory = new Factory( Room.class, RoomDTO.class, Integer.class, emf);

        hotelFactory.create();
        roomFactory.create();
        ApplicationConfig.registerRoutes(app, hotelFactory);
        ApplicationConfig.registerRoutes(app, roomFactory);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
            emf.close();
        }));
        app.start(7070);

        System.out.println("=== MAIN IS COMPLETE ===");
    }
}