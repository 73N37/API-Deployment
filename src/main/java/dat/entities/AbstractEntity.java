package dat.entities;
import dat.factories.Atom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public abstract class AbstractEntity<   Entity  extends AbstractEntity,
                                        ID      extends Serializable>  {

    protected Entity parentEntity;
    protected Entity childEntity;
    protected String test = "Every decendent can access this string";
    protected Class<? extends Atom> unitClass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

//    public AbstractEntity(Class<? extends Entity> entityClass) {
//        this.unitClass = entityClass;
//    }

    public AbstractEntity() {
        this.unitClass = this.getClass();
    }
}
