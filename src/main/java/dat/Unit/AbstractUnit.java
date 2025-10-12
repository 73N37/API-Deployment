package dat.Unities;

/*
    This is the super-class for AbstractDTO & AbstractEntity
    I haven't added functionality YET.
    But for mow it acts as a way to interact with both Entities and DTOs,
    in case their comes a day when i need it.
 */


import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;
import dat.Factories.AbstractFactory;

import java.io.Serializable;

public abstract class AbstractUnit<Entity extends AbstractEntity, DTO extends AbstractDTO, ID extends Serializable> {
    // Available to BOTH AbstractData & AbstractFactory
        public Class<?> getUnitClass(){
            return this.getClass();
        }

    public static abstract class AbstractData<Entity extends AbstractEntity, DTO extends AbstractDTO, ID extends Serializable> {
            public abstract Object getIdentifier();
            enum DataType{
                DATA, INFRASTRUCTURE,UNKNOWN
            }
            public DataType getDataType(){
                if (this instanceof AbstractData) return DataType.DATA;
                /*
                TODO: Jeg blev nød til at opgraderer fra Java 17 (Corretto Alpine) til Java SDK 21,
                TODO: fordi jeg fik en fejl besked på linje 35 vedrørende AbstractFactory().
                TODO: som sagde 
                 */
                if (this instanceof AbstractFactory()) return DataType.INFRASTRUCTURE;
                return DataType.UNKNOWN;
            }

    }
}




