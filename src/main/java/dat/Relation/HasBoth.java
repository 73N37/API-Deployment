package dat.Relation;

public interface HasBoth<Parent, Child>
        extends IsParent<Child>,
                IsChild<Parent>
{
    // Inherits all methods from HasParent & HasChild
    // This is meant as the inverse inheritance of AbstractFactory
}
