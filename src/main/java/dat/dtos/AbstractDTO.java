package dat.dtos;
import lombok.Getter;
import dat.Atom;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter
public abstract class AbstractDTO<DTO extends AbstractDTO> implements Atom {
    //protected DTO dto;
    protected final  Class<? extends Atom> unitClass;
    protected Long id;

    public AbstractDTO(){
        this.unitClass = this.getUnitClass();
    }

    @Override
    public Class<? extends AbstractDTO> getUnitClass(){
        return this.getClass();
    }
}
