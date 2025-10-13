package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

public final class TestData {
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
    private static TestData.Entity      globalEntity;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static TestData.Record      globalRecord;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static TestData.Methods     globalMethod;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static TestData.Annotation  globalAnnotation;

    @Annotation(requiresGlobalState = true, value = "FIELD")
    private static TestData.Interface   globalInterface;

    @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
    private TestData(){}

    @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
    public TestData getInstance(){
        if(this == null) return new TestData();
        else return this;
    }

    @lombok.Setter
    @lombok.Getter
    @Annotation(value = "ENTITY", dependsOn = {TestData.class})
    private static class Entity
    {   // The ONLY purpose of this class is to be manipulated from an outside classes
        // This class must ONLY contain a Constructor with public static Fields

        @jakarta.persistence.Id
        @Annotation( value = "FIELD")
        private static java.lang.Integer   id;

        @Annotation( value = "FIELD")
        private static java.lang.String    name;

        @Annotation(requiresGlobalState = true, value = "CONSTRUCTOR")
        private Entity(java.lang.String   name,
                       java.lang.Integer  id)
        {
            this.name =     name;
            this.id =       id;
            globalEntity =  this;
        }
    }

    @Annotation(requiresGlobalState = true, value = "METHOD", dependsOn = {TestData.class})
    public abstract static class Methods implements Interface
    {   // TODO: This class is exclusively used for defining Methods
        // TODO: Every method needs to be public static
        private Methods(){globalMethod = this;}

        // ########################{Global Methods}######################################
        @Annotation( value = "READ-METHOD")
        public static TestData.Entity getEntity(){
            return globalEntity;
        }

        @Annotation(requiresGlobalState = true, value = "UPDATE-METHOD", dependsOn = {TestData.Entity.class})
        public static void setEntity(TestData.Entity entity){
            globalEntity = entity;
        }

        @Annotation( value = "READ-METHOD")
        public static TestData.Record getRecord(){
            return globalRecord;
        }

        @Annotation(requiresGlobalState = true, value = "UPDATE-METHOD", dependsOn = {TestData.Record.class})
        public static void setRecord(TestData.Record record){
            globalRecord = record;
        }

        @Annotation( value = "READ-METHOD")
        public static TestData.Methods getMethod(){
            return globalMethod;
        }

        @Annotation( value = "READ-METHOD")
        public static TestData.Annotation getAnnotation(){
            return globalAnnotation;
        }

        @Annotation( value = "READ-METHOD")
        public static TestData.Interface getInterface(){
            return globalInterface;
        }

        // ########################{Record Methods}######################################
        @Annotation(value = "RECORD", dependsOn = java.lang.Integer.class)
        public static TestData.Record putRecord(java.lang.Integer id){
            return new TestData.Record(id);
        }

        @Annotation(value = "RECORD", dependsOn = {java.lang.Integer.class, java.lang.String.class})
        public static TestData.Record putRecord(java.lang.Integer id, java.lang.String name){
            return new TestData.Record(id, name);
        }

        @Annotation(value = "RECORD", dependsOn = TestData.Record.class )
        public static java.lang.Integer getId(Record record){
            return record.id();
        }

        @Annotation(value = "RECORD", dependsOn = TestData.Entity.class)
        public static TestData.Record entityToRecord(Entity entity){
            return new TestData.Record(entity.id, entity.name);
        }

        // ########################{Entity Methods}######################################
        @Annotation(value = "ENTITY", dependsOn = {java.lang.String.class, java.lang.Integer.class})
        public static TestData.Entity putEntity(java.lang.String name, java.lang.Integer id){
            return new TestData.Entity(name, id);
        }

        @Annotation(value = "ENTITY")
        public static java.lang.String getEntityName(){
            return Entity.name;
        }

        @Annotation(value = "ENTITY", dependsOn = TestData.Entity.class)
        public static java.lang.Integer getId(Entity entity){
            return entity.id;
        }

        @Annotation(value = "ENTITY",dependsOn = TestData.Record.class)
        public static Entity recordToEntity(Record record){
            return new TestData.Entity(record.name(), record.id());
        }
    }

    @Annotation(value = "CONSTRUCTOR", dependsOn = {java.lang.Integer.class, java.lang.String.class})
    private record Record(java.lang.Integer id, java.lang.String name)
    {
        // TODO: This method is exclusively used to store data between Methods, Fields & Classes
        // Since records are immutable data can ONLY be assigned on instantiation
        @Annotation( value = "CONSTRUCTOR", dependsOn = java.lang.Integer.class)
        private Record(java.lang.Integer id) {
            this(id,null);
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
        default boolean isValid() {
            return getId() != null && getId().toString().matches("^[0-9]+$");
        }

        // Annotation-driven CRUD check
        @Annotation(value = "CrudValidator", dependsOn = {dat.Security.entities.Role.class, java.lang.String.class})
        default boolean canPerformCrud(dat.Security.entities.Role role, java.lang.String operation) {
            return switch(operation.toUpperCase()) {
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
        Class<?>[] dependsOn() default {};
    }
}
