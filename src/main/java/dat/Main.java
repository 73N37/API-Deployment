package dat;
import dat.Config.ApplicationConfig;
import dat.Config.HibernateConfig;
import dat.TestPackage.TestInformation;
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


        System.out.println("DTO Data = " + new TestInformation.Data().putDTO("Through hard work comes EXCELLENCE"));
        System.out.println("Entity Data = " + new TestInformation.Data().putEntity( "Merovingian"));
        System.out.println("globalEntity Name = {Merovingian} = " + new TestInformation.Data().getEntity());
        System.out.println("globalDTO Name {Through hard work comes EXCELLENCE}, " + new TestInformation.Data().getDTO());
        System.out.println("=== MAIN IS COMPLETE ===");
    }
}