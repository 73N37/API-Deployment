package dat.Blueprint.Unit;

public enum UnitType
{   // Return types for getUnitType()
    DATA,               // Inherits from Unit (Entities & DTOs)
    INFRASTRUCTURE,     // Inherits from Unit (Factory) [InterfaceDAO, InterfaceService, InterfaceController, InterfaceRoute] inherits from AbstractFactory
    UNIT,               // Is Unit
    SECURITY,
    ERROR;              // Is NOT Unit (This should NEVER be possible, regard this as en Exception in enum form)
}
