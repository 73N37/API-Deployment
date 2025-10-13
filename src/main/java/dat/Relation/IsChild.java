package dat.Relation;
import dat.Instance.Unit.Unit;

import java.util.Set;

public interface IsChild<Parent extends Unit>
{
    Set<Parent> getParentsSet();
    void postParent(Parent parent);
    void deleteParent(Parent parent);
    void clearParents(); // TODO Assign MODERATOR access ONLY
}
