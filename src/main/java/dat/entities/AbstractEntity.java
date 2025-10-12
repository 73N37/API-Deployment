package dat.entities;
import dat.relations.Unit;
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
                                                extends Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;
}
