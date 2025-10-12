package dat.Instance.Controller;

import dat.Blueprint.DTO.AbstractDTO;
import dat.Blueprint.Entity.AbstractEntity;
import dat.Instance.Factory.Factory;
import jakarta.persistence.EntityManagerFactory;

import java.io.Serializable;

public class Controller extends Factory {
    public Controller(Class<? extends AbstractEntity>   entityClass,
                      Class<? extends AbstractDTO>      dtoClass,
                      Class<? extends Serializable>     idClass,
                      EntityManagerFactory              emf)
    {
        super(entityClass, dtoClass, idClass, emf);
    }
}
