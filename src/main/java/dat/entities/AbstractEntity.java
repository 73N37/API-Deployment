package dat.entities;
import dat.Unit;
import dat.dtos.AbstractDTO;
import jakarta.persistence.*;
import lombok.Getter;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public abstract class AbstractEntity<Entity extends AbstractEntity> implements Unit {

    protected String test = "Every decendent can access this string";
    protected Class<? extends Unit> unitClass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

//    public AbstractEntity(Class<? extends Entity> entityClass) {
//        this.unitClass = entityClass;
//    }

    public AbstractEntity() {
        this.unitClass = this.getClass();
    }
}
