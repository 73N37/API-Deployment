package dat.Relation;
import java.util.Set;

public interface IsParent<Child>
{
    Set<Child> getChildren();
    void addChild(Child child);
    void removeChild(Child child);
    void clearChildren();       // TODO Assign MODERATOR access ONLY
}
