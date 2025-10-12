package dat.Instance.DTO;

import dat.Annotation.IgnoreMapping;
import dat.Annotation.MapTo;
import dat.Instance.Entity.Hotel;

import java.util.HashSet;
import java.util.Set;

public class TestHotelDTO extends dat.Blueprint.DTO.AbstractDTO<Integer>
{
    @MapTo("hotelName")
    private String hotelName;   // Maps to entity's "hotelName" Field
    private String hotelAddress;
    @IgnoreMapping
    private Hotel.HotelType hotelType; // TODO: Will be ignored by "dtoToEntity" method due to @IgnoreMapping
    private Set<RoomDTO> rooms = new HashSet<>();

    public TestHotelDTO(Hotel hotel){
        super(hotel.getId());
        this.hotelName = hotel.getHotelName();
        this.hotelAddress = hotel.getHotelAddress();
        this.hotelType = hotel.getHotelType();
        // this.rooms = hotel.getRooms();
    }
}
