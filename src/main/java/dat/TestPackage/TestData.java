package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

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

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static dat.TestPackage.TestData.Entity  globalEntity;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static dat.TestPackage.TestData.Record  globalRecord;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static dat.TestPackage.TestData.Methods globalMethod;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static dat.TestPackage.TestData.Annotation  globalAnnotation;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static dat.TestPackage.TestData.Interface   globalInterface;

    @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
    private TestData(){}

    @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
    public TestData getInstance()
    {
        if(this == null) return new TestData();
        else return this;
    }

    private interface Unit{
        // This interface is just a super-class.
        // Since records cant extend from abstract classes,
        // I was forced to use an interface
    }

    @lombok.Setter
    @lombok.Getter
    @Annotation(value = "ENTITY", dependsOn = {TestData.class})
    private static class Entity implements Unit
    {   // The ONLY purpose of this class is to be manipulated from an outside classes
        // This class must ONLY contain a Constructor with public static Fields

        @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        @jakarta.persistence.Id
        @Annotation( value = "FIELD")
        private static java.lang.Integer   id;

        @Annotation( value = "FIELD")
        private static java.lang.String    name;

        @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
        private Entity(java.lang.String   name)
        {
            this.name =     name;
            globalEntity =  this;
        }
    }



        @Annotation(requiresGlobalState = true, value = "METHOD", dependsOn = {dat.TestPackage.TestData.class})
        public abstract static class Methods implements dat.TestPackage.TestData.Interface
        {   // TODO: This class is exclusively used for defining Methods
            // TODO: Every method needs to be public static
            private Methods()
            {
                globalMethod = this;
            }

            // ########################{Constructor Methods}######################################
            public static dat.TestPackage.TestData.Unit
            constructor(DataType type, String name)
            {
                if (type.equals(DataType.RECORD)) return new dat.TestPackage.TestData.Record(name);
                if (type.equals(DataType.ENTITY)) return new dat.TestPackage.TestData.Entity(name);
                // This is unreachable, since Methods does not allow
                return null;
            }


            // ########################{Global Methods}######################################
            @Annotation( value = "READ-METHOD")
            public static dat.TestPackage.TestData.Entity
            getEntity()
            {
                return globalEntity;
            }

            @Annotation(requiresGlobalState = true, value = "UPDATE-METHOD", dependsOn = {dat.TestPackage.TestData.Entity.class})
            public static void
            setEntity(dat.TestPackage.TestData.Entity entity)
            {
                globalEntity = entity;
            }

            @Annotation( value = "READ-METHOD")
            public static dat.TestPackage.TestData.Record
            getRecord()
            {
                return globalRecord;
            }

            @Annotation(requiresGlobalState = true, value = "UPDATE-METHOD", dependsOn = {TestData.Record.class})
            public static void
            setRecord(dat.TestPackage.TestData.Record record)
            {
                globalRecord = record;
            }

            @Annotation( value = "READ-METHOD")
            public static dat.TestPackage.TestData.Methods
            getMethod()
            {
                return globalMethod;
            }

            @Annotation( value = "READ-METHOD")
            public static dat.TestPackage.TestData.Annotation
            getAnnotation()
            {
                return globalAnnotation;
            }

            @Annotation( value = "READ-METHOD")
            public static dat.TestPackage.TestData.Interface
            getInterface()
            {
                return globalInterface;
            }

            // ########################{Record Methods}######################################
            @Annotation(value = "RECORD", dependsOn = java.lang.Integer.class)
            public static dat.TestPackage.TestData.Record
            putRecord(java.lang.String name)
            {
                return new dat.TestPackage.TestData.Record(name);
            }

            @Annotation(value = "RECORD", dependsOn = {java.lang.Integer.class, java.lang.String.class})
            public static dat.TestPackage.TestData.Record
            putRecord(java.lang.Integer id, java.lang.String name)
            {
                return new TestData.Record(id, name);
            }

            @Annotation(value = "RECORD", dependsOn = dat.TestPackage.TestData.Record.class)
            public static java.lang.Integer
            getId(dat.TestPackage.TestData.Record record)
            {
                return record.id();
            }

            @Annotation(value = "RECORD", dependsOn = dat.TestPackage.TestData.Entity.class)
            public static dat.TestPackage.TestData.Record
            entityToRecord(dat.TestPackage.TestData.Entity entity)
            {
                return new dat.TestPackage.TestData.Record(entity.id, entity.name);
            }

            // ########################{Entity Methods}######################################
            @Annotation(value = "ENTITY", dependsOn = {java.lang.String.class, java.lang.Integer.class})
            public static dat.TestPackage.TestData.Entity
            putEntity(java.lang.String name, java.lang.Integer id)
            {
                return new dat.TestPackage.TestData.Entity(name);
            }

            @Annotation(value = "ENTITY")
            public static java.lang.String
            getEntityName()
            {
                return dat.TestPackage.TestData.Entity.name;
            }

            @Annotation(value = "ENTITY", dependsOn = TestData.Entity.class)
            public static java.lang.Integer
            getId(dat.TestPackage.TestData.Entity entity)
            {
                return entity.id;
            }

            @Annotation(value = "ENTITY", dependsOn = dat.TestPackage.TestData.Record.class)
            public static dat.TestPackage.TestData.Entity
            recordToEntity(dat.TestPackage.TestData.Record record)
            {
                return new dat.TestPackage.TestData.Entity(record.name());
            }
        }

    @Annotation(value = "CONSTRUCTOR")
    private record Record(java.lang.Integer id, java.lang.String name, dat.TestPackage.TestData.DataType record) implements dat.TestPackage.TestData.Unit
    {
        // TODO: This method is exclusively used to store data between Methods, Fields & Classes
        // Since records are immutable data can ONLY be assigned on instantiation
        @Annotation( value = "CONSTRUCTOR", dependsOn = {java.lang.String.class})
        private Record(java.lang.String name)
        {
            this(null,name, dat.TestPackage.TestData.DataType.RECORD);
        }

        @Annotation(value = "CONSTRUCTOR", dependsOn = {java.lang.String.class, java.lang.Integer.class})
        private Record(java.lang.Integer id, java.lang.String name)
        {
            this(id, name, dat.TestPackage.TestData.DataType.RECORD);
        }


    }

    @Annotation(value = "INTERFACE")
    private interface Interface<ID extends java.io.Serializable>
    {   // TODO: This class is exclusively for defining relations to
        //Identity (for annotation-driven validation)
        @Annotation(value = "IDENTIFIER", requiresGlobalState = true)
        ID getId();

        @Annotation(value = "READ-METHOD", dependsOn = dat.Security.entities.Role.class)
        boolean canRead(    dat.Security.entities.Role role);

        @Annotation(value = "WRITE-METHOD", dependsOn = dat.Security.entities.Role.class)
        boolean canWrite(   dat.Security.entities.Role role);

        @Annotation(value = "DELETE-METHOD", dependsOn = dat.Security.entities.Role.class)
        boolean canDelete(  dat.Security.entities.Role role);

        @Annotation(value = "UPDATE-METHOD", dependsOn = dat.Security.entities.Role.class)
        boolean canUpdate( dat.Security.entities.Role role);

        // Validation (reads annotations to validate state)
        @Annotation(value = "VALIDATOR", requiresGlobalState = true)
        default boolean isValid()
        {
            return getId() != null && getId().toString().matches("^[0-9]+$");
        }

        // Annotation-driven CRUD check
        @Annotation(value = "CrudValidator", dependsOn = {dat.Security.entities.Role.class, java.lang.String.class})
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
        java.lang.String value() default "";
        boolean requiresGlobalState() default false;
        java.lang.Class<?>[] dependsOn() default {};
    }

    public enum DataType{
        ENTITY,
        RECORD;
    }

}
