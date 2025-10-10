package dat.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public abstract class AbstractEntity<   Entity  extends AbstractEntity,
                                        ID      extends Serializable>
{
    protected Entity parentEntity;
    protected Entity childEntity;
    protected String test = "Every decendent can access this string";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    public AbstractEntity() {}
}
