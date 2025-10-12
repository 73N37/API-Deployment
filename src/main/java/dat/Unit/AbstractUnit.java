package dat.Unit;

/*
    This is the super-class for AbstractDTO & AbstractEntity
    I haven't added functionality YET.
    But for mow it acts as a way to interact with both Entities and DTOs,
    in case their comes a day when i need it.
 */


import dat.DTO.AbstractDTO;
import dat.Data.AbstractData;
import dat.Entity.AbstractEntity;
import dat.Factory.AbstractFactory;
import dat.Security.controllers.SecurityController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Available to BOTH AbstractData & AbstractFactory (this is the top-class for the entire project)
public abstract class AbstractUnit<ID extends Serializable>
{
    // Unified logger for every class within this project.
    // Since every class inherits from this one, 'log.error(""), log.debug(""), log.info(""), can be called fron any class.
    public Logger log = LoggerFactory.getLogger(getUnitClass());

    //
    public static final Set<AbstractUnit> REGISTRY = ConcurrentHashMap.newKeySet();

    // Defined in AbstractDTO, AbstractEntity & AbstractFactory
    public abstract ID getIdentifier();

    public AbstractUnit()
    {
        REGISTRY.add(this);
    }

    public  Class<?> getUnitClass()
    {
        // Used in Logger log to assign a class
        return this.getClass();
    }

    enum UnitType
    {   // Return types for getUnitType()
        DATA,               // Inherits from AbstractUnit (Entities & DTOs)
        INFRASTRUCTURE,     // Inherits from AbstractUnit (Factory) [AbstractDAO, AbstractService, AbstractController, AbstractRoute] inherits from AbstractFactory
        UNIT,               // Is Unit
        ERROR;              // Is NOT Unit (This should NEVER be possible, regard this as en Exception in enum form)
    }

    public UnitType getUnitType()
    { /*    TODO: Jeg blev nød til at opgraderer fra Java 17 (Corretto Alpine) til Java SDK 21,
            TODO: fordi jeg fik en fejl besked på linje 35 vedrørende AbstractFactory().
            TODO: som sagde "Pattern guards and record patterns are not supported at the language level 17." */

        UnitType result = UnitType.ERROR;
        try {// This method is used on generic methods to determine behavior depending on what UnitType a given instance (Object) or blueprint (Class)
            if (this instanceof AbstractData)       result = UnitType.DATA;
            if (this instanceof AbstractFactory)    result = UnitType.INFRASTRUCTURE;
            if (this instanceof AbstractUnit)       result = UnitType.UNIT;
        } catch (Exception e)
        {
            log.error("An error happen while trying determining a UnitType based on inheritance", e.getMessage(), e);
        }
        return result;
    }

    public boolean hasAnnotation(Class<? extends Annotation> annotationClass){
        boolean result = false;
        try {
            result = this.getClass().isAnnotationPresent(annotationClass);
        } catch (Exception e)
        {
            log.error("An error happen while determining if an Annotation was present or not", e.getMessage(), e);
        }
        return result;
    }

    public Set<AbstractUnit> getUnits(){
        Set<AbstractUnit> result = null;
        try{
            result = Collections.unmodifiableSet(REGISTRY);
        } catch (Exception e)
        {
            log.error("An error happen while trying to assign a Set<{}>. Error happen before th result was returned", getUnitClass(), e.getMessage(), e);
        }
        return result;
    }
}








