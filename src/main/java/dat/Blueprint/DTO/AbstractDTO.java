package dat.Blueprint.DTO;
import dat.Blueprint.Data.AbstractData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public abstract class AbstractDTO<  ID  extends Serializable>
                                        extends AbstractData
{
    public ID id;

    public ID getIdentifier()
    {
        return id;
    }
}
