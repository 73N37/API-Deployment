package dat.relations;
import java.util.Set;

public interface IsChild<Parent>
{
    Set<Parent> getParentsSet();
    void addParent(Parent parent);
    void removeParent(Parent parent);
    void clearParents(); // TODO Assign MODERATOR access ONLY
}
