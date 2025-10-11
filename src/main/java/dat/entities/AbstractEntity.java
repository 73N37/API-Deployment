package dat.entities;
import dat.config.HibernateConfig;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Optional;

@NoArgsConstructor
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

    public static EntityManagerFactory getEMF(){
        return HibernateConfig.createEMF(false);
    }
}
