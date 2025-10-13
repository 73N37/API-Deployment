package dat;
import dat.Config.ApplicationConfig;
import dat.Config.HibernateConfig;
import dat.Instance.DTO.HotelDTO;
import dat.Instance.DTO.RoomDTO;
import dat.Instance.Entity.Hotel;
import dat.Instance.Entity.Room;
import dat.Instance.Factory.Factory;
import dat.TestPackage.TestBlueprint.*;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;
import dat.TestPackage.TestBlueprint.Test.TestDTO;


public class Main
{ // TODO Please read the book!!! We had a deal...
    public static void main(String[] args) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);
        EntityManagerFactory emf = HibernateConfig.createEMF(false);

        Factory<Hotel, HotelDTO, Integer> hotelFactory = new Factory( Hotel.class, HotelDTO.class, Integer.class, emf);
        Factory<Room, RoomDTO, Integer> roomFactory = new Factory( Room.class, RoomDTO.class, Integer.class, emf);

        String testIds = "empty";
        Test test = new Test(testIds);
        dat.TestPackage.TestBlueprint.Test.TestDTO dto1 = new Test.TestDTO(dat.TestPackage.TestBlueprint.Test.TestEntity.id);
        Test.TestDTO dto2 = new Test.TestDTO(1, "73N37");
        Test.TestEntity entity = new Test.TestEntity(dto2);


        hotelFactory.create();
        roomFactory.create();
        ApplicationConfig.registerRoutes(app, hotelFactory);
        ApplicationConfig.registerRoutes(app, roomFactory);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
            emf.close();
        }));
        app.start(7070);


        System.out.println("String entity = " + entity.name);
        System.out.println("String entity = " + Test.TestInterface.testString());
        System.out.println("String entity = " + Test.TestMethods.testString());
        System.out.println("Integer dto1 = " + dto1.id());
        System.out.println("String dto2 = " + dto2.name());

        System.out.println("=== MAIN IS COMPLETE ===");
    }
}