package dat.dtos;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import dat.Unit;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter
public abstract class AbstractDTO<DTO extends AbstractDTO> implements Unit {
    //protected DTO dto;
    protected final  Class<? extends Unit> unitClass;
    protected Long id;

    public AbstractDTO(){
        this.unitClass = this.getUnitClass();
    }

    @Override
    public Class<? extends AbstractDTO> getUnitClass(){
        return this.getClass();
    }
}
