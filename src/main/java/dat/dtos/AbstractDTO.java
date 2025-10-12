package dat.dtos;
import dat.relations.Unit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public abstract class AbstractDTO<  DTO extends AbstractDTO,
                                    ID  extends Serializable>
                                        extends Unit {
    protected ID id;

}
