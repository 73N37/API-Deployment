package dat.Relation;

import dat.Instance.Unit.Unit;

public interface HasBoth<Parent extends Unit, Child extends Unit>
        extends IsParent<Child>,
                IsChild<Parent>
{
    // Inherits all methods from HasParent & HasChild
    // This is meant as the inverse inheritance of AbstractFactory
}
