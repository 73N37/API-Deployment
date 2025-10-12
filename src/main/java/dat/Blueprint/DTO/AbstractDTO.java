package dat.DTO;
import dat.Data.AbstractData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public abstract class AbstractDTO<  DTO extends AbstractDTO,
                                    ID  extends Serializable>
                                        extends AbstractData
{
    public ID id;

    public ID getIdentifier()
    {
        return id;
    }
}
