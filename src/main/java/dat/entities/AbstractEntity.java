package dat.entities;
import dat.Unit;
import dat.dtos.AbstractDTO;
import jakarta.persistence.*;


@Entity
@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public abstract class AbstractEntity<Entity extends AbstractEntity> implements Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Object id;

    protected final Class<? extends Unit> unitClass;


    public AbstractEntity() {
        this.unitClass = this.getUnitClass();
    }

    public Class<? extends AbstractEntity> getUnitClass() {
        return this.getClass();
    }
}
