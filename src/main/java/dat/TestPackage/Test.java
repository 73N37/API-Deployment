package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes is through
 */

public final class Test {
    // TODO
    /*  Global-scope Fields:
        Since these Fields doesn't have getters or setters,
        The ONLY way to access them is though my entity methods
    */

    private static Entity                   globalEntity;
    private static Record                   globalRecord;
    private static Methods                  globalMethod;
    private static Annotation               globalAnnotation;
    private static Interface                globalInterface;

    private Test(){}

    public Test getInstance(){
        if(this == null) return new Test();
        else return this;
    }

    @lombok.Setter
    @lombok.Getter
    @Annotation(value = "Entity", dependsOn = {})
    private static class Entity
    {   // The ONLY purpose of this class is to be manipulated from an outside classes
        // This class must ONLY contain a Constructor with public static Fields

        @jakarta.persistence.Id
        private static Integer   id;
        private static String    name;

        private Entity(String   name,
                       Integer  id)
        {
            this.name =     name;
            this.id =       id;
            globalEntity =  this;
        }
    }

    @Annotation(requiresGlobalState = true, value = "Method")
    public abstract static class Methods implements Interface
    {   // TODO: This class is exclusively used for defining Methods
        // TODO: Every method needs to be static
        private Methods(){globalMethod = this;}

        // ########################{Global Methods}######################################
        @Annotation(requiresGlobalState = true, value = "Global")
        public static Entity getEntity(){return globalEntity;}

        @Annotation(requiresGlobalState = true, value = "Global")
        public static Record getDTO(){return globalRecord;}

        @Annotation(requiresGlobalState = true, value = "Global")
        public static Methods getMethod(){return globalMethod;}

        @Annotation(requiresGlobalState = true, value = "Global")
        public static Annotation getAnnotation(){return globalAnnotation;}

        @Annotation(requiresGlobalState = true, value = "Global")
        public static Interface getInterface(){return globalInterface;}

        // ########################{Record Methods}######################################
        @Annotation(value = "Record")
        public static Record putRecord(Integer id){return new Record(id);}

        @Annotation(value = "Record")
        public static Record putRecord(Integer id, String name){return new Record(id, name);}

        @Annotation(value = "Record")
        public static Integer getId(Record record){return record.id;}

        @Annotation(value = "Record")
        public static Record entityToRecord(Entity entity){return new Record(entity.id, entity.name);}

        // ########################{Entity Methods}######################################
        @Annotation(value = "Entity")
        public static Entity putEntity(String name, Integer id){return new Entity(name, id);}

        @Annotation(value = "Entity")
        public static String getEntityName(){return Entity.name;}

        @Annotation(value = "Entity")
        public static Integer getId(Entity entity){return entity.id;}

        @Annotation(value = "Entity")
        public static Entity recordToEntity(Record record){return new Entity(record.name(), record.id());}
    }

    @Annotation(value = "Record")
    private record Record(Integer id, String name)
    {   // TODO: This method is exclusively used to store data between Methods, Fields & Classes
        // Since records are immutable data can ONLY be assigned on instantiation

        private Record(Integer id){
            this(id, null);
            globalRecord = this;
        }
    }

    @Annotation(value = "Interface")
    private interface Interface
    {   // TODO: This class is exclusively for defining relations to
        boolean canRead(    dat.Security.entities.Role role);
        boolean canWrite(   dat.Security.entities.Role role);
        boolean canDelete(  dat.Security.entities.Role role);
    }

    private @interface Annotation
    {
        String value() default "";
        boolean requiresGlobalState() default false;
        Class<? extends Entity>[] dependsOn() default {};
    }
}
