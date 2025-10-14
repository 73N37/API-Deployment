package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

import jakarta.persistence.*;

import java.lang.annotation.Annotation;

public final class TestData
{
    /*      TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

    // TODO
    /*  Global-scope Fields:
        Since these Fields doesn't have getters or setters,
        The ONLY way to access them is though my entity methods
    */

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    private static dat.TestPackage.TestData.Entity  globalEntity;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    private static dat.TestPackage.TestData.Record  globalRecord;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    private static dat.TestPackage.TestData.Methods globalMethod;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    public static dat.TestPackage.TestData.Annotation  globalAnnotation;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    private static dat.TestPackage.TestData.Interface   globalInterface;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.FIELD)
    public static dat.TestPackage.TestData instance;

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    private TestData(){}

    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    public TestData getInstance()
    {
        if(instance == null) instance = new TestData();
        return instance;
    }

    private interface DataUnit {
        // This interface is just a super-class.
        // Since records cant extend from abstract classes,
        // I was forced to use an interface
    }

    @lombok.Setter
    @lombok.Getter
    @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.ENTITY)
    private static class Entity implements DataUnit
    {   // The ONLY purpose of this class is to be manipulated from an outside classes
        // This class must ONLY contain a Constructor with public static Fields

        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.FIELD)
        @Id
        private static java.lang.Integer   id;

        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.FIELD)
        private static java.lang.String    name;

        @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
        private Entity(java.lang.String   name)
        {
            this.name =     name;
            globalEntity =  this;
        }

        @Override
        public java.lang.String toString(){

            return "ID = {"+ id +"}, Name = {"+ name +"}";
        }
    }

        @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.METHOD)
        public abstract static class Methods implements dat.TestPackage.TestData.Interface
        {   // TODO: This class is exclusively used for defining Methods
            // TODO: Every method needs to be public static
            private Methods()
            {
                //globalMethod = this;
            }

            public static Class<? extends dat.TestPackage.TestData.DataUnit> getUnitClass(DataType type){
                // I chose not to @Override Java's 'getClass()' method.
                // Just in case if I at some point in the future would need its functionality
                if (type == DataType.ENTITY) return dat.TestPackage.TestData.Entity.class;
                if (type == DataType.RECORD) return dat.TestPackage.TestData.Record.class;
                return null;
            }

            // ########################{Constructor Methods}######################################
            public static dat.TestPackage.TestData.DataUnit
            constructor(dat.TestPackage.TestData.DataType data, String name)
            {
                if (data.equals(dat.TestPackage.TestData.DataType.RECORD)) return new dat.TestPackage.TestData.Record(name);
                if (data.equals(dat.TestPackage.TestData.DataType.ENTITY)) return new dat.TestPackage.TestData.Entity(name); // TODO No ID is generated. You need to create a DAO methods first (use JPA persist)
                // This is unreachable, since Methods does not allow
                return null;
            }

            // ########################{Global Methods}######################################
            @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
            public static dat.TestPackage.TestData.Entity
            getEntity()
            {
                return globalEntity;
            }

            @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Entity.class})
            private static void
            putGlobalEntity(dat.TestPackage.TestData.Entity value)
            {
                globalEntity = value;
            }

            @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
            public static dat.TestPackage.TestData.Record
            getGlobalRecord()
            {
                return globalRecord;
            }

            @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Record.class})
            private static void
            putGlobalRecord(dat.TestPackage.TestData.Record value)
            {
                globalRecord = value;
            }

            @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
            public static dat.TestPackage.TestData.Methods
            getGlobalMethod()
            {
                return globalMethod;
            }

            @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Methods.class})
            private static void
            putGlobalMethod(Methods value)
            {
                globalMethod = value;
            }

            @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
            public static dat.TestPackage.TestData.Annotation
            getAnnotation()
            {
                return globalAnnotation;
            }

            @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Methods.class})
            private static void
            putGlobalAnnotation(dat.TestPackage.TestData.Annotation value)
            {
                globalAnnotation = value;
            }

            @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
            public static dat.TestPackage.TestData.Interface
            getInterface()
            {
                return globalInterface;
            }

            @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Interface.class})
            private static void
            putInterface(Interface value)
            {
                globalInterface = value;
            }

            // ########################{Record Methods}######################################
            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = java.lang.Integer.class)
            public static dat.TestPackage.TestData.Record
            putRecord(java.lang.String name)
            {
                return new dat.TestPackage.TestData.Record(name);
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {java.lang.Integer.class, java.lang.String.class})
            public static dat.TestPackage.TestData.Record
            putRecord(java.lang.Integer id, java.lang.String name)
            {
                return new TestData.Record(id, name);
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.TestPackage.TestData.Record.class)
            public static java.lang.Integer
            getId(dat.TestPackage.TestData.Record record)
            {
                return record.id();
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.TestPackage.TestData.Entity.class)
            public static dat.TestPackage.TestData.Record
            entityToRecord(dat.TestPackage.TestData.Entity entity)
            {
                return new dat.TestPackage.TestData.Record(entity.id, entity.name);
            }

            // ########################{Entity Methods}######################################
            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.ENTITY, dependsOn = {java.lang.String.class, java.lang.Integer.class})
            public static dat.TestPackage.TestData.Entity
            putEntity(java.lang.String name, java.lang.Integer id)
            {
                return new dat.TestPackage.TestData.Entity(name);
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.ENTITY)
            public static java.lang.String
            getEntityName()
            {
                return dat.TestPackage.TestData.Entity.name;
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.ENTITY, dependsOn = dat.TestPackage.TestData.Entity.class)
            public static java.lang.Integer
            getId(dat.TestPackage.TestData.Entity entity)
            {
                return entity.id;
            }

            @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.ENTITY, dependsOn = dat.TestPackage.TestData.Record.class)
            public static dat.TestPackage.TestData.Entity
            recordToEntity(dat.TestPackage.TestData.Record record)
            {
                return new dat.TestPackage.TestData.Entity(record.name());
            }
        }

    @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    private record Record(java.lang.Integer id, java.lang.String name, dat.TestPackage.TestData.DataType record) implements DataUnit
    {
        // TODO: This method is exclusively used to store data between Methods, Fields & Classes
        // Since records are immutable data can ONLY be assigned on instantiation
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR, dependsOn = {java.lang.String.class})
        private Record(java.lang.String name)
        {
            this(null,name, dat.TestPackage.TestData.DataType.RECORD);
            dat.TestPackage.TestData.Methods.putGlobalRecord(this);
        }

        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR, dependsOn = {java.lang.String.class, java.lang.Integer.class})
        private Record(java.lang.Integer id, java.lang.String name)
        {
            this(id, name, dat.TestPackage.TestData.DataType.RECORD);
            dat.TestPackage.TestData.Methods.putGlobalRecord(this);
        }
    }

    @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.INTERFACE)
    private interface Interface<ID extends java.io.Serializable>
    {   // TODO: This class is exclusively for defining relations to
        //Identity (for annotation-driven validation)
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.IDENTIFIER, requiresGlobalState = true)
        ID getId();

        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.READ, dependsOn = dat.Security.entities.Role.class)
        boolean canRead(    dat.Security.entities.Role role);

        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.WRITE, dependsOn = dat.Security.entities.Role.class)
        boolean canWrite(   dat.Security.entities.Role role);

        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.DELETE, dependsOn = dat.Security.entities.Role.class)
        boolean canDelete(  dat.Security.entities.Role role);

        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.Security.entities.Role.class)
        boolean canUpdate( dat.Security.entities.Role role);

        // Validation (reads annotations to validate state)
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.VALIDATOR, requiresGlobalState = true)
        default boolean isValid()
        {
            return getId() != null && getId().toString().matches("^[0-9]+$");
        }

        // Annotation-driven CRUD check
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CRUD_VALIDATOR, dependsOn = {dat.Security.entities.Role.class, java.lang.String.class})
        default boolean canPerformCrud(dat.Security.entities.Role role, java.lang.String operation)
        {
            return switch(operation.toUpperCase())
            {
                case "READ-METHOD" -> canRead(role);
                case "WRITE-METHOD", "UPDATE-METHOD" -> canWrite(role);
                case "DELETE-METHOD" -> canDelete(role);
                default -> false;
            };
        }
    }

    private @interface Annotation
    {
        //java.lang.String value() default "";
        dat.TestPackage.TestData.OperationType[] value() default {dat.TestPackage.TestData.OperationType.UNKNOWN};
        boolean requiresGlobalState() default false;
        java.lang.Class<?>[] dependsOn() default {};
    }

    private enum DataType{
        ENTITY,
        RECORD;
    }
    
    private enum OperationType{
        ENTITY,
        DATA,
        IDENTIFIER,
        VALIDATOR,
        CRUD_VALIDATOR,
        UPDATE,
        READ,
        WRITE,
        DELETE,
        CONSTRUCTOR,
        FIELD,
        METHOD,
        INTERFACE,
        UNKNOWN;
    }

}
