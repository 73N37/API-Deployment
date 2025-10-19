package dat.TestPackage;

/**
 * TestData is a comprehensive data management class that provides a controlled API
 * for managing Entity and DTO objects through a centralized Methods class.
 *
 * <p><b>Design Philosophy:</b></p>
 * <ul>
 *   <li>All internal classes (Entity, DTO, Interface, Annotation) are private</li>
 *   <li>The ONLY way to manipulate these classes is through the public static Methods class</li>
 *   <li>This ensures encapsulation and controlled access to data structures</li>
 *   <li>Global state is maintained for tracking active instances</li>
 * </ul>
 *
 * <p><b>Key Components:</b></p>
 * <ul>
 *   <li><b>Entity:</b> Mutable class for persistent data (JPA-compatible)</li>
 *   <li><b>DTO:</b> Immutable dto for transferring data between layers</li>
 *   <li><b>Methods:</b> Public API for all CRUD operations</li>
 *   <li><b>Interface:</b> Security contract for permission validation</li>
 *   <li><b>Annotation:</b> Metadata for operation types and dependencies</li>
 * </ul>
 *
 * @author 73N37
 * @version 1.0
 * @since 2025-10-15
 */
public final class TestInformation
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

    // The globalEntity is NOT the same Class as the Entity Class itself, since it is a layer above the Entity Object
    @TestInformation.Annotation(    requiresGlobalState = true,
                                    value               = TestInformation.OperationType.FIELD)
    private static TestInformation.Entity   globalEntity;

    /**
     * Global reference to the currently active DTO class.
     * This field stores the Class object of the most recently created DTO instance.
     * It acts as a registry layer above individual DTO objects for tracking purposes.
     *
     * <p>This field is accessed and modified exclusively through Methods class operations.</p>
     * <p>Lombok @Getter generates a public getter for this field.</p>
     */
    @TestInformation.Annotation(    requiresGlobalState = true,
                                    value               = TestInformation.OperationType.FIELD)
    private static TestInformation.DTO      globalDTO;



    @TestInformation.Annotation(    requiresGlobalState = true,
                                    value               = TestInformation.OperationType.FIELD)
    private static TestInformation          instance;

    /**
     * Private constructor to prevent direct instantiation.
     * Use getInstance() method to obtain the singleton instance.
     */
    @TestInformation.Annotation(   requiresGlobalState = true)
    private TestInformation(){}

    /**
     * Retrieves the singleton instance of Data.
     * If no instance exists, creates a new one (lazy initialization).
     *
     * <p><b>Thread Safety:</b> Not thread-safe. Considering adding synchronization for multi-threaded environments.</p>
     *
     * @return The singleton Data instance
     */
    public static class Data
    {
        // TODO: This class mus be the factory for TestInformation [class],
        //       like Factory is to TestOperation [class]

        @TestInformation.Annotation(   requiresGlobalState = true)
        public TestInformation
//###############################################[TestInformation Methods]###############################################
        getInstance()
        {   // getInstance() [method] begins
            // Check if instance has been created yet
            if (instance == null) instance = new TestInformation();
            // Return the singleton instance
            return instance;
        }   // getInstance() [method] ends


//###############################################[DTO Methods]###############################################
        public TestInformation.DTO
        getDTO()
        {   // getDTO() [method] begins
            // If the Field 'globalDTO' is null, null will be returned
            if (globalDTO == null) return null;
            // If the Field 'globalDTO' in NOT null, the DTO will be returned
            return globalDTO;
        }   // getDTO [method] ends

        public java.lang.Integer
        getDtoId()
        {   // getDtoId() [method] begins
            // Uses getDTO to retrieve the DTO which id we want returned
            return getDTO().getId();
        }   // getDtoId() [method] ends

        @TestInformation.Annotation(value = TestInformation.OperationType.CONSTRUCTOR)
        public dat.TestPackage.TestInformation.DTO
        putDTO(java.lang.Integer id,
               java.lang.String name)
        {
            return new dat.TestPackage.TestInformation.DTO(id, name);
        }

        @TestInformation.Annotation(value = TestInformation.OperationType.CONSTRUCTOR)
        public dat.TestPackage.TestInformation.DTO
        putDTO(java.lang.String name)
        {
            return new dat.TestPackage.TestInformation.DTO(name);
        }



//###############################################[Entity Methods]###############################################
        public TestInformation.Entity
        getEntity()
        {   // getEntity() [method] begins
            // If the Field 'globalEntity' is null, null will be returned
            if (globalEntity == null) return null;
            // If the Field 'globalEntity' is NOT null, the Entity will be returned
            return globalEntity;
        }   // getEntity() [method] ends

        public java.lang.Integer
        getEntityId()
        {   // getEntityId() [method] begins
            // Uses getEntity to retrieve the Entity which id we want returned
            return getEntity().getId();
        }   // getEntityId() [method] ends

        @TestInformation.Annotation(value = TestInformation.OperationType.CONSTRUCTOR)
        public dat.TestPackage.TestInformation.Entity
        putEntity(String name)
        {
            return new dat.TestPackage.TestInformation.Entity(name);   // @return a new instance of 'DTO' (sub-class)
        }

        @TestInformation.Annotation(value = TestInformation.OperationType.CONSTRUCTOR)
        public dat.TestPackage.TestInformation.Entity
        putEntity(java.lang.Integer id,
                  java.lang.String name)
        {
            return new dat.TestPackage.TestInformation.Entity(id, name);
        }

//###############################################[Converter Methods]###############################################


    }

    /**
     * Marker interface that serves as a common parent for both Entity and DTO types.
     *
     * <p>This interface provides a polymorphic umbrella allowing methods to accept
     * either Entity or DTO objects. This is necessary because Java DTOs cannot
     * extend from abstract classes, so an interface provides the shared type hierarchy.</p>
     *
     * <p><b>Design Rationale:</b> Enables type-safe polymorphism between mutable entities
     * and immutable DTOs without forcing inheritance constraints.</p>
     */
    static abstract class DataUnit {
        // This abstract class just a super-class to DTO & Entity.
        java.lang.String name;
        java.lang.String getName()
        {   // getName() [method] begins
            return this.name;
        }   // getName() [method] ends

        java.lang.Integer id;
        java.lang.Integer getId()
        {   // getId() [method] begins
            return this.id;
        }   // getId() [method] ends
    }

    /**
     * Entity class represents a mutable data object compatible with JPA persistence.
     *
     * <p><b>Purpose:</b> This class is designed to be manipulated by external classes
     * through the Methods API. It contains only a constructor and public static fields
     * to maintain simplicity and direct access patterns.</p>
     *
     * <p><b>Persistence:</b> Uses JPA annotations (@Id) for database mapping.
     * The id field is intended to be auto-generated by the persistence layer.</p>
     *
     * <p><b>State Management:</b> Upon construction, automatically registers itself
     * as the global entity by updating the globalEntity field.</p>
     *
     * <p>Lombok annotations provide automatic getter/setter generation.</p>
     */
    @TestInformation.Annotation(    value        = {TestInformation.OperationType.CLASS},
                                    dataUnitType = {TestInformation.DataType.ENTITY})
    protected static class Entity extends DataUnit
    {
        /**
         * Primary key identifier for the entity.
         * Marked with @Id for JPA persistence. Expected to be auto-generated by the database.
         *
         * <p><b>Note:</b> Will be null until the entity is persisted to the database.</p>
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.FIELD)
        @lombok.Getter
        @lombok.Setter
        private java.lang.Integer id;

        /**
         * The name property of the entity.
         * This field stores the identifying name/label for the entity instance.
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.FIELD)
        @lombok.Getter
        @lombok.Setter
        private java.lang.String name;

        /**
         * Constructs a new Entity with the specified name.
         * Automatically registers this entity class as the global entity.
         *
         * @param name The name to assign to this entity
         */
        @TestInformation.Annotation(   requiresGlobalState = true)
        Entity(java.lang.String name)
        {
            // Assign the provided name to the instance field
            this.name =     name;
            // Register this entity's class as the current global entity
            globalEntity =  this;
        }

        @TestInformation.Annotation(   requiresGlobalState = true)
        Entity(java.lang.Integer id,
               java.lang.String name)
        {
            this.id = id;
            this.name = name;
            globalEntity = this;
        }

        /**
         * Provides a string representation of the entity showing its ID and name.
         *
         * @return A formatted string in the format "ID = {id}, Name = {name}"
         */
        @TestInformation.Annotation(   value = {TestInformation.OperationType.METHOD})
        @Override
        public java.lang.String toString(){

            return "ID = {"+ id +"}, Name = {"+ name +"}";
        }
    }

    protected static class DTO extends DataUnit
    {
        /**
         * Primary key identifier for the entity.
         * Marked with @Id for JPA persistence. Expected to be auto-generated by the database.
         *
         * <p><b>Note:</b> Will be null until the entity is persisted to the database.</p>
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.FIELD)
        @lombok.Getter

        private java.lang.Integer id;
        /**
         * The name property of the entity.
         * This field stores the identifying name/label for the entity instance.
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.FIELD)
        @lombok.Getter
        private java.lang.String name;

        DTO(TestInformation.Entity entity)
        {   // DTO [constructor] begins
            this.name = entity.name;
            globalDTO = this;
        }   // DTO [constructor] ends

        DTO(java.lang.Integer   id,
            java.lang.String    name)
        {
            this.name = name;
            this.id = id;
            globalDTO = this;
        }

        DTO(java.lang.String name)
        {
            this.name = name;
            globalDTO = this;
        }

        @TestInformation.Annotation(   value = {TestInformation.OperationType.METHOD})
        @Override
        public java.lang.String toString(){

            return "ID = {"+ id +"}, Name = {"+ name +"}";
        }
    }

    /**
     * Methods class serves as the exclusive public API for all data operations.
     *
     * <p><b>Design Pattern:</b> This class implements a Facade pattern, providing
     * a simplified interface to the complex subsystem of Entity, DTO, and global state management.</p>
     *
     * <p><b>Key Characteristics:</b></p>
     * <ul>
     *   <li>All methods are public static for easy access</li>
     *   <li>No instance creation allowed (private constructor)</li>
     *   <li>Provides CRUD operations for both Entity and DTO</li>
     *   <li>Manages global state through getter/setter methods</li>
     *   <li>Handles conversions between Entity and DTO types</li>
     * </ul>
     *
     * <p><b>Method Categories:</b></p>
     * <ul>
     *   <li><b>Constructor Methods:</b> Factory methods for creating Entity/DTO instances</li>
     *   <li><b>Global Methods:</b> Getters/setters for global state fields</li>
     *   <li><b>DTO Methods:</b> Operations specific to DTO objects</li>
     *   <li><b>Entity Methods:</b> Operations specific to Entity objects</li>
     *   <li><b>Conversion Methods:</b> Transform between Entity and DTO types</li>
     * </ul>
     */
    @TestInformation.Annotation(requiresGlobalState = true, value = TestInformation.OperationType.CLASS)
    public abstract static class
    Methods<E extends TestInformation.Entity, DTO extends TestInformation.DTO>
            implements TestInformation.Interface
    {
        // Common CRUD methods that needs to implemented in the sub-class
        public abstract DTO create(DTO dto);
        public abstract DTO read(java.lang.Integer id);
        public abstract DTO update(java.lang.Integer id, DTO dto);
        public abstract void delete(java.lang.Integer id);

        /**
         * Private constructor prevents instantiation.
         * All methods in this class are static and should be accessed without creating instances.
         */
        private Methods() {}

        /**
         * Factory method that dynamically creates instances of DataUnit subtypes using reflection.
         *
         * <p>Since Java's type erasure prevents direct instantiation of generic types (new T()),
         * this method uses reflection to invoke the no-argument constructor of the provided class type.</p>
         *
         * <p><b>Reflection Process:</b></p>
         * <ul>
         *   <li>getDeclaredConstructor() - Retrieves the no-arg constructor from the Class object</li>
         *   <li>newInstance() - Invokes that constructor to create a new instance</li>
         * </ul>
         *
         * @param type The Class object representing the type to instantiate (Entity or DTO)
         * @param <Data> The generic type parameter extending DataUnit
         * @return A new instance of the specified type
         * @throws IllegalArgumentException if the type cannot be instantiated (no accessible no-arg constructor)
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.METHOD)
         static <Data extends TestInformation.DataUnit> Data create(java.lang.Class<Data> type) {
            try {
                // Uses reflection to invoke the no-argument cnstructor
                // This is necessary because Java's type erasure prevents 'new T()'
                return type.getDeclaredConstructor().newInstance();
            } catch (java.lang.ReflectiveOperationException e) {
                throw new java.lang.IllegalArgumentException("Cannot instantiate " + type.getName(), e);
            }
        }

        /**
         * Retrieves the Class object for the specified DataType.
         *
         * <p>This method provides runtime type information without using Java's built-in
         * getClass() method, preserving that functionality for potential future use.</p>
         *
         * @param type The DataType enum value (ENTITY or DTO)
         * @return The Class object representing the specified type, or null if type is unrecognized
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.METHOD)
        static java.lang.Class<? extends TestInformation.DataUnit> getUnitClass(DataType type){
            // Check if the requested type is ENTITY
            if (type == TestInformation.DataType.ENTITY) return TestInformation.Entity.class;
            // Check if the requested type is DTO
            if (type == TestInformation.DataType.DTO) return TestInformation.DTO.class;
            // Return null for unrecognized types
            return null;
        }


        /**
         * Converts a DataUnit to an Entity class reference.
         *
         * <p><b>Warning:</b> This method appears to have a logic issue - it compares
         * a DataUnit against OperationType.ENTITY instead of DataType.ENTITY.</p>
         *
         * @param data The DataUnit to convert
         * @return The Entity class reference if the data represents an entity, null otherwise
         */
        public static java.lang.Class<? extends TestInformation.Entity>
        dataUnitToEntity(TestInformation.DataType data)
        {
            // TODO {TLDR}: Checks if the data unit is a entity type, and return Entity.class if it is indeed a entity type.
            // TODO {TLDR}: If anythings fails return null;

            if (data. // Performs an operation on the @param data
                    equals(TestInformation.   // Checks if @param equals something inside TestData (super-class {public final class})
                                                    DataType.ENTITY)) return TestInformation.   // If @param equals OperationType.ENTITY @return something inside data.TestPackage.TestData
                                                                                                    Entity. // If @param equals OperationType.ENTITY @return something inside data.TestPackage.TestData.Entity
                                                                                                            class;  // If every step was successful @return data.TestPackage.TestData.Entity.class
            else return null; // If any of the steps above-mentioned fails return null
        }


        /**
         * Converts a DataUnit to a DTO class reference.
         *
         * <p><b>Warning:</b> This method appears to have a logic issue - it compares
         * a DataUnit against OperationType.DTO instead of DataType.DTO.</p>
         *
         * @param data The DataUnit to convert
         * @return The DTO class reference if the data represents a DTO, null otherwise
         */
        public static java.lang.Class<? extends TestInformation.DTO>
        dataUnitToDTO(TestInformation.DataUnit data)
        {
            // TODO {TLDR}: Checks if the data unit is a dto type, and return DTO.class if it is indeed a dto type.
            // TODO {TLDR}: If anythings fails return null;

            if (data. // performs an operation on the @param data
                    equals(TestInformation.   // Checks if @param equals something inside TestData (super-class {public final class})
                                                    DataType.DTO)) return TestInformation.   // If @param equals OperationType.DTO @return something inside data.TestPackage.TestData
                                                                                                    DTO. // If @param equals OperationType.DTO @return something inside data.TestPackage.TestData.DTO
                                                                                                            class; // If every step was successful @return data.TestPackage.TestData.DTO.class
            else return null;   // If any of the steps above-mentioned fails return null
        }

//        /**
//         * Converts a DataType enum to a DTO class reference.
//         *
//         * @param data The DataType enum value to check
//         * @return The DTO class reference if data is DTO type, null otherwise
//         */
//        public static Class<? extends DTO>
//        dataUnitToDTO(dat.TestPackage.TestData.DataType data)
//        {
//            // Check if the data type is DTO
//            if (data.equals(dat.TestPackage.TestData.DataType.DTO)) return (DTO.class);
//            else return null;
//        }

        // ########################{Global Methods}######################################

        /**
         * Retrieves the globally stored Entity class reference.
         *
         * <p>This returns the Class object of the most recently created Entity,
         * providing access to the current global entity state.</p>
         *
         * @return The current global Entity class, or null if no Entity has been created
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.READ)
        public static TestInformation.Entity
        getEntity()
        {
            return globalEntity;
        }

        /**
         * Updates the global Entity class reference.
         *
         * <p>Use this method to manually set which Entity class is considered the global entity.
         * This is automatically called when creating new entities but can be overridden.</p>
         *
         * @param value The Entity class to set as the global entity
         */
        @TestInformation.Annotation(requiresGlobalState = true, value = {TestInformation.OperationType.UPDATE}, dependsOn = {TestInformation.Entity.class})
        public static void
        putEntity(TestInformation.Entity value)
        {
            // Update the global entity reference
            globalEntity = value;
        }

        /**
         * Retrieves the globally stored DTO class reference.
         *
         * @return The current global DTO class, or null if no DTO has been created
         */
        @TestInformation.Annotation( value = TestInformation.OperationType.READ)
        public static TestInformation.DTO
        getDTO()
        {
            return globalDTO;
        }

        /**
         * Updates the global DTO class reference.
         *
         * @param value The DTO class to set as the global dto
         */
        @TestInformation.Annotation(requiresGlobalState = true, value = TestInformation.OperationType.UPDATE, dependsOn = {TestInformation.DTO.class})
        public static TestInformation.DTO
        putDTO(TestInformation.DTO value)
        {
            // Update the global dto reference
            globalDTO = value;
            return value;
        }

        // ########################{DTO Methods}######################################
        /**
         * Creates a new DTO with both ID and name.
         *
         * <p>Use this method when creating a dto from persisted data that already has an ID.</p>
         *
         * @param id The unique identifier for the DTO
         * @param name The name for the DTO
         * @return A new DTO instance with the specified ID and name
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.UPDATE, dependsOn = { java.lang.Integer.class,
                                                                                                java.lang.String.class})
        public static TestInformation.DTO
        putDTO(java.lang.Integer id, java.lang.String name)
        {
            // Create and return a new DTO with both ID and name
            return new TestInformation.DTO(id, name);
        }

        /**
         * Extracts the ID from a DataUnit (DTO).
         *
         * <p>This method converts the DTO to an entity to retrieve the ID.
         * This is necessary because the DTO structure stores ID differently than Entity.</p>
         *
         * @param dto The DataUnit (expected to be a DTO) to extract ID from
         * @return The ID of the dto, or null if no ID exists
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.UPDATE, dependsOn = TestInformation.DTO.class)
        public static java.lang.Integer
        getId(TestInformation.DTO dto)
        {
            // Convert DTO to Entity to access ID field
            // Return the ID from the entity
            return dtoToEntity(dto).getId();
        }

        /**
         * Converts an Entity to a DTO.
         *
         * <p>This transformation creates an immutable DTO from a mutable Entity,
         * useful for transferring data between layers (e.g., from DAO to DTO).</p>
         *
         * @param entity The Entity to convert
         * @return A new DTO containing the entity's ID and name
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.UPDATE, dependsOn = TestInformation.Entity.class)
        public static TestInformation.DTO
        entityToDTO(TestInformation.Entity entity)
        {
            // Create new DTO from entity's ID and name fields
            return new TestInformation.DTO(entity.id, entity.name);
        }

        /**
         * Retrieves the name from the global DTO.
         *
         * <p>This method accesses the name field of the most recently created DTO
         * by calling the DTOs name() accessor method.</p>
         *
         * @return The name of the globalDTO
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.READ, dataUnitType = {TestInformation.DataType.DTO})
        public static java.lang.String
        getDtoName()
        {
            // Call the DTOs name() accessor (auto-generated by DTO declaration)
            TestInformation.DTO result = getDTO();
            return result.getName();
        }

        // ########################{Entity Methods}######################################

        /**
         * Creates a new Entity with the specified name.
         *
         * <p><b>Note:</b> The id parameter is declared but not used in the method body.
         * The ID will be null until the entity is persisted through JPA.</p>
         *
         * @param name The name for the new entity
         * @param id The ID parameter (currently unused - consider removing or implementing)
         * @return A new Entity instance with the specified name
         */
        @TestInformation.Annotation(   dataUnitType    = TestInformation.DataType.ENTITY,
                                                dependsOn       = { java.lang.String.class,
                                                                    java.lang.Integer.class})
        public static TestInformation.Entity
        putEntity(java.lang.String name, java.lang.Integer id)
        {
            // Create new Entity (id parameter is not used)
            return new TestInformation.Entity(name);
        }

        /**
         * Retrieves the name from the global Entity.
         *
         * <p>This method directly accesses the static name field of the global entity class.</p>
         *
         * @return The name of the global entity
         */
        @TestInformation.Annotation(dataUnitType = TestInformation.DataType.ENTITY)
        public static java.lang.String
        getEntityName()
        {
            // Access the static name field from the global entity
            return globalEntity.name;
        }

        /**
         * Extracts the ID from a specific Entity instance.
         *
         * <p>This is an overloaded version of getId() that works directly with Entity objects.</p>
         *
         * @param entity The Entity to extract the ID from
         * @return The entity's ID, or null if not persisted
         */
        @TestInformation.Annotation(value          = {TestInformation.OperationType.READ},
                                            dataUnitType    = {TestInformation.DataType.ENTITY},
                                            dependsOn       = {TestInformation.Entity.class})
        public static java.lang.Integer
        getId(TestInformation.Entity entity)
        {
            // Return the ID field from the entity
            return entity.id;
        }

        /**
         * Converts a DTO to an Entity.
         *
         * <p>This transformation creates a mutable Entity from an immutable DTO,
         * useful when preparing to persist data or when modification is needed.</p>
         *
         * <p><b>Note:</b> The DTOs ID is not transferred to the Entity.
         * The Entity will have a null ID until persisted.</p>
         *
         * @param dto The DTOs to convert
         * @return A new Entity containing the DTOs name
         */
        @TestInformation.Annotation(   value = {TestInformation.OperationType.READ},
                                                dataUnitType = {TestInformation.DataType.ENTITY},
                                                dependsOn = {TestInformation.DTO.class})
        public static TestInformation.Entity
        dtoToEntity(TestInformation.DTO dto)
        {
            // Create new Entity from DTOs name (ID is not transferred)
            return new TestInformation.Entity(dto.getId(), dto.getName());
        }
    }

    /**
     * Interface defines a security and validation contract for data operations.
     *
     * <p><b>Purpose:</b> This interface provides:</p>
     * <ul>
     *   <li>Identity validation through getId()</li>
     *   <li>Permission checking through canRead/canWrite/canDelete/canUpdate methods</li>
     *   <li>Annotation-driven validation through isValid()</li>
     *   <li>CRUD operation validation through canPerformCrud()</li>
     * </ul>
     *
     * <p><b>Design Pattern:</b> Security Contract - implementations must define
     * permission rules for different user roles.</p>
     *
     * @param <ID> The type of the identifier (must be Serializable)
     */
    @TestInformation.Annotation(value = TestInformation.OperationType.INTERFACE)
    private interface Interface<ID extends java.io.Serializable>
    {
        /**
         * Retrieves the unique identifier for this object.
         *
         * <p>Used for identity validation and tracking.</p>
         *
         * @return The unique identifier
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.IDENTIFIER, requiresGlobalState = true)
        ID getId();

        /**
         * Checks if the specified role has read permission.
         *
         * @param role The user role to check
         * @return true if the role can read, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.READ, dependsOn = dat.Security.entities.Role.class)
        boolean canRead(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has write permission.
         *
         * @param role The user role to check
         * @return true if the role can write, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.WRITE, dependsOn = dat.Security.entities.Role.class)
        boolean canWrite(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has delete permission.
         *
         * @param role The user role to check
         * @return true if the role can delete, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.DELETE, dependsOn = dat.Security.entities.Role.class)
        boolean canDelete(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has update permission.
         *
         * @param role The user role to check
         * @return true if the role can update, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.UPDATE, dependsOn = dat.Security.entities.Role.class)
        boolean canUpdate(dat.Security.entities.Role role);

        /**
         * Validates the current state of the object.
         *
         * <p>Reads annotations to validate state. Currently checks:</p>
         * <ul>
         *   <li>ID is not null</li>
         *   <li>ID contains only numeric characters</li>
         * </ul>
         *
         * @return true if the object is in a valid state, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.VALIDATOR, requiresGlobalState = true)
        default boolean isValid()
        {
            // Check that ID exists and is numeric
            return getId() != null && getId().toString().matches("^[0-9]+$");
        }

        /**
         * Performs annotation-driven CRUD validation based on operation type.
         *
         * <p>This method uses the operation string to determine which permission
         * method to invoke (canRead, canWrite, canDelete).</p>
         *
         * <p><b>Supported Operations:</b></p>
         * <ul>
         *   <li>"READ-METHOD" - checks canRead()</li>
         *   <li>"WRITE-METHOD" or "UPDATE-METHOD" - checks canWrite()</li>
         *   <li>"DELETE-METHOD" - checks canDelete()</li>
         * </ul>
         *
         * @param role The user role to validate against
         * @param operation The CRUD operation being performed
         * @return true if the role has permission for the operation, false otherwise
         */
        @TestInformation.Annotation(value = TestInformation.OperationType.CRUD_VALIDATOR, dependsOn = { dat.Security.entities.Role.class,
                                                                                                        java.lang.String.class})
        default boolean canPerformCrud(dat.Security.entities.Role role, java.lang.String operation)
        {
            // Convert operation to uppercase and route to appropriate permission check
            return switch(operation.toUpperCase())
            {
                case "READ-METHOD" -> canRead(role);
                case "WRITE-METHOD", "UPDATE-METHOD" -> canWrite(role);
                case "DELETE-METHOD" -> canDelete(role);
                default -> false; // Deny permission for unknown operations
            };
        }
    }

    /**
     * Custom annotation for marking and documenting operation types and dependencies.
     *
     * <p><b>Purpose:</b> This annotation provides metadata about:</p>
     * <ul>
     *   <li>The type of operation being performed (CRUD, validation, etc.)</li>
     *   <li>Whether global state is required</li>
     *   <li>Dependencies on other classes</li>
     * </ul>
     *
     * <p><b>Usage:</b> Apply to methods, fields, classes, and constructors to document
     * their operational characteristics and requirements.</p>
     */
    @java.lang.annotation.Target({
            java.lang.annotation.ElementType.TYPE,
            java.lang.annotation.ElementType.METHOD,
            java.lang.annotation.ElementType.FIELD,
            java.lang.annotation.ElementType.CONSTRUCTOR
    })
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
    private @interface Annotation
    {
        /**
         * The operation type(s) this element performs.
         * @return An array of OperationType values (default: UNKNOWN)
         */
        TestInformation.OperationType[] value() default {TestInformation.OperationType.UNKNOWN};

        /**
         * Indicates whether this element requires global state to function.
         * @return true if global state is required, false otherwise (default: false)
         */
        boolean requiresGlobalState() default false;

        /**
         * Lists the classes this element depends on.
         * @return An array of Class objects representing dependencies (default: empty)
         */
        java.lang.Class<?>[] dependsOn() default {};

        /**
         * Specifies which data unit type this element belongs to.
         * @return The DataType (ENTITY or RECORD), empty array if not applicable
         */
        TestInformation.DataType[] dataUnitType() default {};

        /**
         * Whether this is the primary type definition
         * @return true if primary type, false otherwise (default: false)
         */
        boolean isPrimaryType() default false;
    }


//    @java.lang.annotation.Target({
//            java.lang.annotation.ElementType.TYPE,
//            java.lang.annotation.ElementType.METHOD,
//            java.lang.annotation.ElementType.FIELD,
//            java.lang.annotation.ElementType.CONSTRUCTOR
//    })
//    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
//    private @interface DataUnitType
//    {
//        /**
//         * Specifies which data unit type this element belongs to.
//         * @return The DataType (ENTITY or RECORD)
//         */
//        dat.TestPackage.TestData.DataType[] value();
//
//        /** Whether this is the primary type definition */
//        boolean isPrimaryType() default false;
//    }
    /**
     * Enum representing the two main data structure types in this system.
     *
     * <p><b>ENTITY:</b> Represents mutable, persistable data objects</p>
     * <p><b>RECORD:</b> Represents immutable, transferable data objects</p>
     */
    public enum DataType
    {
        UNKNOWN,
        /** Mutable data structure for persistence */
        ENTITY,
        /** Immutable data structure for transfer */
        DTO;
    }
    
    /**
     * Enum categorizing all possible operation types in the system.
     *
     * <p>Used by the @Annotation to document what type of operation
     * a method, field, or class represents.</p>
     */
    private enum OperationType
    {
        /** General data operations */
        DATA,
        /** Identity/ID-related operations */
        IDENTIFIER,
        /** Validation operations */
        VALIDATOR,
        /** CRUD validation operations */
        CRUD_VALIDATOR,
        /** Update/modify operations */
        UPDATE,
        /** Read/retrieve operations */
        READ,
        /** Write/create operations */
        WRITE,
        /** Delete/remove operations */
        DELETE,
        /** Constructor operations */
        CONSTRUCTOR,
        /** Field-related operations */
        FIELD,
        /** Method-related operations */
        METHOD,
        /** Interface-related operations */
        INTERFACE,
        /** Class-related opeations */
        CLASS,
        /** Unknown/undefined operation type */
        UNKNOWN;
    }

}
