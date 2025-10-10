//package dat.daos.impl;
//
//
//import dat.daos.InterfaceDAO;
//import dat.dtos.HotelDTO;
//import dat.dtos.RoomDTO;
//import dat.entities.Hotel;
//import dat.entities.Room;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.TypedQuery;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
////@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
//public class RoomDAO extends AbstractDAO<Room, Room> {
//
//    private static EntityManagerFactory emf;
//
//    public RoomDAO (EntityManagerFactory emf){
//        super(emf);
//    }
//
//    public HotelDTO addRoomToHotel(Object hotelId, RoomDTO roomDTO ) {
//        try (EntityManager em = emf.createEntityManager()) {
//            em.getTransaction().begin();
//            Room room = new Room(roomDTO);
//            Hotel hotel = em.find(Hotel.class, hotelId);
//            hotel.addRoom(room);
//            em.persist(room);
//            Hotel mergedHotel = em.merge(hotel);
//            em.getTransaction().commit();
//            return new HotelDTO(mergedHotel);
//        }
//    }
//
//    public Function<Object, Boolean> validateHotelRoomNumber = (roomNumber) -> {
//        try (EntityManager em = emf.createEntityManager()) {
//            Room room = em.find(Room.class, roomNumber);
//            return room != null;
//        }
//    };
//
//    public Boolean validateHotelRoomNumber(Object roomNumber, Object hotelId) {
//        try (EntityManager em = emf.createEntityManager()) {
//            Hotel hotel = em.find(Hotel.class, hotelId);
//            return hotel.getRooms().stream().anyMatch(r -> r.getRoomNumber().equals(roomNumber));
//        }
//    }
//
//}
