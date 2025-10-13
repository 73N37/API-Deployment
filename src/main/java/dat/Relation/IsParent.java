package dat.Relation;
import dat.Instance.Unit.Unit;

import java.util.Set;

public interface IsParent<Child extends Unit>
{
    Set<Child> getChildren();
    void postChild(Child child);
    void deleteChild(Child child);
    void clearChildren();       // TODO Assign MODERATOR access ONLY
}
