package dat.dtos;

import dat.annotations.IgnoreMapping;
import dat.annotations.MapTo;
import dat.entities.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HotelDTO extends AbstractDTO<HotelDTO> {

    private Integer id;
    @MapTo("hotelName")
    private String hotelName;   // Maps to entity's "hotelName" Field
    private String hotelAddress;
    @IgnoreMapping
    private Hotel.HotelType hotelType; // TODO: Will be ignored by "dtoToEntity" method due to @IgnoreMapping
    private Set<RoomDTO> rooms = new HashSet<>();

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.hotelName = hotel.getHotelName();
        this.hotelAddress = hotel.getHotelAddress();
        this.hotelType = hotel.getHotelType();
        if (hotel.getRooms() != null)
        {
            hotel.getRooms().forEach( room -> rooms.add(new RoomDTO(room)));
        }
    }

    public HotelDTO(String hotelName, String hotelAddress, Hotel.HotelType hotelType)
    {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelType = hotelType;
    }

    public static List<HotelDTO> toHotelDTOList(List<Hotel> hotels) {
        return hotels.stream().map(HotelDTO::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof HotelDTO hotelDto)) return false;

        return getId().equals(hotelDto.getId());
    }

    @Override
    public int hashCode()
    {
        return getId().hashCode();
    }

}
