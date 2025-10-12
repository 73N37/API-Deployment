package dat;
import dat.config.ApplicationConfig;
import dat.config.HibernateConfig;
import dat.controllers.InterfaceController;
import dat.dtos.AbstractDTO;
import dat.dtos.HotelDTO;
import dat.dtos.RoomDTO;
import dat.entities.AbstractEntity;
import dat.entities.Hotel;
import dat.entities.Room;
import dat.factories.Factory;
import dat.routes.AbstractRoutes;
import dat.routes.InterfaceRoutes;
import dat.factories.AbstractClass;
import io.javalin.Javalin;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(ApplicationConfig::configuration);
        EntityManagerFactory emf = HibernateConfig.createEMF(false);

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