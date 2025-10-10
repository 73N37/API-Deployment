package dat.dtos;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public abstract class AbstractDTO<  DTO extends AbstractDTO,
                                    ID  extends Serializable> {
    protected DTO parentDTO;
    protected DTO childDTO;
    protected ID id;

}
