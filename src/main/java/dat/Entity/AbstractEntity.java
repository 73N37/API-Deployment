package dat.Entity;
import dat.Data.AbstractData;
import dat.Unit.AbstractUnit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public abstract class AbstractEntity<   Entity  extends AbstractEntity,
                                        ID      extends Serializable>
                                                extends AbstractData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public ID id;

    @Override
    public ID getIdentifier()
    {
        return id;
    }

}
