package dat;
import dat.config.ApplicationConfig;
import dat.config.HibernateConfig;
import dat.dtos.HotelDTO;
import dat.dtos.RoomDTO;
import dat.entities.Hotel;
import dat.entities.Room;
import dat.factories.Factory;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        new Factory(Hotel.class, HotelDTO.class, Integer.class, HibernateConfig.createEMF(false)).create();
        new Factory(Room.class, RoomDTO.class, Integer.class, HibernateConfig.createEMF(false)).create();
        new ApplicationConfig().startServer(7070);
    }
}