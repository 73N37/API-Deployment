package dat.Instance.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass // Hibernate retrieve the table name automatically from the class-name
public class Entity<ID extends Serializable>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public ID id;
}
