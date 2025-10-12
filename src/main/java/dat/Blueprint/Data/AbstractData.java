package dat.Blueprint.Data;
import dat.Blueprint.Unit.AbstractUnit;

import java.io.Serializable;

public abstract class AbstractData<ID extends Serializable> extends AbstractUnit
{
    // Shared data operations (for entities & DTOs) will go here
    // getIdentifier() must be implemented by subclasses
    // Defined in AbstractDTO & AbstractEntity
    public abstract ID getIdentifier();
}
