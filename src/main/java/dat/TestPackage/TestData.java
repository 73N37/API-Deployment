package dat.TestPackage;

/**
 * TestData is a comprehensive data management class that provides a controlled API
 * for managing Entity and Record objects through a centralized Methods class.
 *
 * <p><b>Design Philosophy:</b></p>
 * <ul>
 *   <li>All internal classes (Entity, Record, Interface, Annotation) are private</li>
 *   <li>The ONLY way to manipulate these classes is through the public static Methods class</li>
 *   <li>This ensures encapsulation and controlled access to data structures</li>
 *   <li>Global state is maintained for tracking active instances</li>
 * </ul>
 *
 * <p><b>Key Components:</b></p>
 * <ul>
 *   <li><b>Entity:</b> Mutable class for persistent data (JPA-compatible)</li>
 *   <li><b>Record:</b> Immutable record for transferring data between layers</li>
 *   <li><b>Methods:</b> Public API for all CRUD operations</li>
 *   <li><b>Interface:</b> Security contract for permission validation</li>
 *   <li><b>Annotation:</b> Metadata for operation types and dependencies</li>
 * </ul>
 *
 * @author 73N37
 * @version 1.0
 * @since 2025-10-15
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

    private static java.lang.Integer id;

    // The globalEntity is NOT the same Class as the Entity Class itself, since it is a layer above the Entity Object
    @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                            value               = dat.TestPackage.TestData.OperationType.FIELD)
    @lombok.Getter
    private static dat.TestPackage.TestData.Entity globalEntity;

    /**
     * Global reference to the currently active Record class.
     * This field stores the Class object of the most recently created Record instance.
     * It acts as a registry layer above individual Record objects for tracking purposes.
     *
     * <p>This field is accessed and modified exclusively through Methods class operations.</p>
     * <p>Lombok @Getter generates a public getter for this field.</p>
     */
    @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                            value               = dat.TestPackage.TestData.OperationType.FIELD)
    @lombok.Getter
    private static dat.TestPackage.TestData.Record  globalRecord;



    @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                            value               = dat.TestPackage.TestData.OperationType.FIELD)
    public static dat.TestPackage.TestData instance;

    /**
     * Private constructor to prevent direct instantiation.
     * Use getInstance() method to obtain the singleton instance.
     */
    @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                            value               = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    TestData(){}

    /**
     * Retrieves the singleton instance of TestData.
     * If no instance exists, creates a new one (lazy initialization).
     *
     * <p><b>Thread Safety:</b> Not thread-safe. Considering adding synchronization for multi-threaded environments.</p>
     *
     * @return The singleton TestData instance
     */
    @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                            value               = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    public TestData getInstance()
    {
        // Check if instance has been created yet
        if(instance == null) instance = new TestData();
        // Return the singleton instance
        return instance;
    }

    /**
     * Marker interface that serves as a common parent for both Entity and Record types.
     *
     * <p>This interface provides a polymorphic umbrella allowing methods to accept
     * either Entity or Record objects. This is necessary because Java records cannot
     * extend from abstract classes, so an interface provides the shared type hierarchy.</p>
     *
     * <p><b>Design Rationale:</b> Enables type-safe polymorphism between mutable entities
     * and immutable records without forcing inheritance constraints.</p>
     */
    interface DataUnit {
        // This interface is just a super-class.
        // Since records cant extend from abstract classes,
        // This is a functional-interface since it only has 1 method
        @dat.TestPackage.TestData.Annotation(value = {dat.TestPackage.TestData.OperationType.FIELD})
        static java.lang.Integer getId()
        {
            return dat.TestPackage.TestData.id;
        }
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
    @dat.TestPackage.TestData.Annotation(   value        = {dat.TestPackage.TestData.OperationType.CLASS},
                                            dataUnitType = {dat.TestPackage.TestData.DataType.ENTITY})
    static class Entity implements DataUnit
    {
        /**
         * Primary key identifier for the entity.
         * Marked with @Id for JPA persistence. Expected to be auto-generated by the database.
         *
         * <p><b>Note:</b> Will be null until the entity is persisted to the database.</p>
         */
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.FIELD)
        @lombok.Getter
        @lombok.Setter
        static java.lang.Integer id;

        /**
         * The name property of the entity.
         * This field stores the identifying name/label for the entity instance.
         */
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.FIELD)
        @lombok.Getter
        @lombok.Setter
        static java.lang.String name;

        /**
         * Constructs a new Entity with the specified name.
         * Automatically registers this entity class as the global entity.
         *
         * @param name The name to assign to this entity
         */
        @dat.TestPackage.TestData.Annotation(   requiresGlobalState = true,
                                                value               = {dat.TestPackage.TestData.OperationType.CONSTRUCTOR})
        Entity(java.lang.String   name)
        {
            // Assign the provided name to the instance field
            this.name =     name;
            // Register this entity's class as the current global entity
            globalEntity =  this;
        }
        
        /**
         * Retrieves the ID of this entity.
         *
         * @return The entity's ID, or null if not yet persisted
         */
        static java.lang.Integer
        getId()
        {
            return id;
        }

        /**
         * Provides a string representation of the entity showing its ID and name.
         *
         * @return A formatted string in the format "ID = {id}, Name = {name}"
         */
        @Override
        public java.lang.String toString(){

            return "ID = {"+ id +"}, Name = {"+ name +"}";
        }
    }
    /**
     * Methods class serves as the exclusive public API for all data operations.
     *
     * <p><b>Design Pattern:</b> This class implements a Facade pattern, providing
     * a simplified interface to the complex subsystem of Entity, Record, and global state management.</p>
     *
     * <p><b>Key Characteristics:</b></p>
     * <ul>
     *   <li>All methods are public static for easy access</li>
     *   <li>No instance creation allowed (private constructor)</li>
     *   <li>Provides CRUD operations for both Entity and Record</li>
     *   <li>Manages global state through getter/setter methods</li>
     *   <li>Handles conversions between Entity and Record types</li>
     * </ul>
     *
     * <p><b>Method Categories:</b></p>
     * <ul>
     *   <li><b>Constructor Methods:</b> Factory methods for creating Entity/Record instances</li>
     *   <li><b>Global Methods:</b> Getters/setters for global state fields</li>
     *   <li><b>Record Methods:</b> Operations specific to Record objects</li>
     *   <li><b>Entity Methods:</b> Operations specific to Entity objects</li>
     *   <li><b>Conversion Methods:</b> Transform between Entity and Record types</li>
     * </ul>
     */
    @dat.TestPackage.TestData.Annotation(requiresGlobalState = true)
    public abstract static class Methods implements dat.TestPackage.TestData.Interface
    {
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
         * @param type The Class object representing the type to instantiate (Entity or Record)
         * @param <Data> The generic type parameter extending DataUnit
         * @return A new instance of the specified type
         * @throws IllegalArgumentException if the type cannot be instantiated (no accessible no-arg constructor)
         */
         static <Data extends dat.TestPackage.TestData.DataUnit> Data create(java.lang.Class<Data> type) {
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
         * @param type The DataType enum value (ENTITY or RECORD)
         * @return The Class object representing the specified type, or null if type is unrecognized
         */
        static java.lang.Class<? extends dat.TestPackage.TestData.DataUnit> getUnitClass(DataType type){
            // Check if the requested type is ENTITY
            if (type == dat.TestPackage.TestData.DataType.ENTITY) return dat.TestPackage.TestData.Entity.class;
            // Check if the requested type is RECORD
            if (type == dat.TestPackage.TestData.DataType.RECORD) return dat.TestPackage.TestData.Record.class;
            // Return null for unrecognized types
            return null;
        }

        // ########################{Constructor Methods}######################################
        public static dat.TestPackage.TestData.Record
        recordConstructor(java.lang.String name)
        {
            return new dat. // return something that lives in 'dat' (super-package)
                    TestPackage.    // return something that lives in 'dat.TestPackage' (sub.package)
                    TestData.   // return something that lives in 'dat.TestPackage.TestData (super-class)
                    Record(name);   // @return a new instance of 'Record' (sub-class)
        }

        public static dat.TestPackage.TestData.Entity
        entityConstructor(java.lang.String name)
        {
            return new dat. // return something that lives in the 'dat' (super-package)
                    TestPackage.    // return something that lives in  'dat.TestPackage' (sub-package)
                    TestData.   // return something that lives in 'dat.TestPackage.TestData' (super-class)
                    Entity(name);   // @return a new instance of 'Entity' (sub-class)
        }


        public static dat.TestPackage.TestData.DataUnit
        constructor(dat.TestPackage.TestData.DataType dataType, java.lang.Integer id, String name)
        {
            // Check if an Entity should be created with ID
            if (dataType.equals(dat.    // Checks if  @param 'dataType' equals something that lives in 'dat' (super-package)
                                TestPackage.    // Checks if @param 'dataType' equals something that lives in 'dat.TestPackage' (sub-package)
                                            TestData.   // Checks if @param 'dataType' equals something that lives in 'dat.TestPackage.TestData' (super-class)
                                                    DataType.   // Checks if @param 'dataType equals something that lives in 'dat.TestPackage.TestData.DataType' (sub-class [enum])
                                                            ENTITY)) // Checks if 'dataType'
            {   // Since every check has passed the next code block will be executed
                dat.TestPackage.TestData.Entity entity = new dat.TestPackage.TestData.Entity(name);
                entity.id = id;
                return entity;
            }

            // Check if a Record should be created with ID
            if (dataType == dat.TestPackage.TestData.DataType.RECORD) {
                return new dat.TestPackage.TestData.Record(id, name);
            }
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
        public static java.lang.Class<? extends dat.TestPackage.TestData.Entity>
        dataUnitToEntity(dat.TestPackage.TestData.DataType data)
        {
            // TODO {TLDR}: Checks if the data unit is a entity type, and return Entity.class if it is indeed a entity type.
            // TODO {TLDR}: If anythings fails return null;

            if (data. // Performs an operation on the @param data
                    equals(dat. // Checks if @param equals something inside dat (super-package)
                                TestPackage.    // Checks if @param equals something inside TestPackage (sub-package)
                                            TestData.   // Checks if @param equals something inside TestData (super-class {public final class})
                                                    DataType.ENTITY)) return dat.  // Checks if @param equals ENTITY inside OperationType (sub-class {enum}})
                                                                                TestPackage.    // If @param equals OperationType.ENTITY @return something inside dat.TestPackage
                                                                                            TestData.   // If @param equals OperationType.ENTITY @return something inside data.TestPackage.TestData
                                                                                                    Entity. // If @param equals OperationType.ENTITY @return something inside data.TestPackage.TestData.Entity
                                                                                                            class;  // If every step was successful @return data.TestPackage.TestData.Entity.class
            else return null; // If any of the steps above-mentioned fails return null
        }


        /**
         * Converts a DataUnit to a Record class reference.
         *
         * <p><b>Warning:</b> This method appears to have a logic issue - it compares
         * a DataUnit against OperationType.RECORD instead of DataType.RECORD.</p>
         *
         * @param data The DataUnit to convert
         * @return The Record class reference if the data represents a record, null otherwise
         */
        public static java.lang.Class<? extends dat.TestPackage.TestData.Record>
        dataUnitToRecord(dat.TestPackage.TestData.DataUnit data)
        {
            // TODO {TLDR}: Checks if the data unit is a record type, and return Record.class if it is indeed a record type.
            // TODO {TLDR}: If anythings fails return null;

            if (data. // performs an operation on the @param data
                    equals(dat. // Checks if @param equals something inside dat (super-package)
                                TestPackage.    // Checks if @param equals something inside TestPackage (sub-package)
                                            TestData.   // Checks if @param equals something inside TestData (super-class {public final class})
                                                    DataType.RECORD)) return dat. // Checks if @param equals RECORD inside OperationType (sub-class {enum}})
                                                                                TestPackage. // If @param equals OperationType.RECORD @return something inside dat.TestPackage
                                                                                            TestData.   // If @param equals OperationType.RECORD @return something inside data.TestPackage.TestData
                                                                                                    Record. // If @param equals OperationType.RECORD @return something inside data.TestPackage.TestData.Record
                                                                                                            class; // If every step was successful @return data.TestPackage.TestData.Record.class
            else return null;   // If any of the steps above-mentioned fails return null
        }

//        /**
//         * Converts a DataType enum to a Record class reference.
//         *
//         * @param data The DataType enum value to check
//         * @return The Record class reference if data is RECORD type, null otherwise
//         */
//        public static Class<? extends Record>
//        dataUnitToRecord(dat.TestPackage.TestData.DataType data)
//        {
//            // Check if the data type is RECORD
//            if (data.equals(dat.TestPackage.TestData.DataType.RECORD)) return (Record.class);
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
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
        public static dat.TestPackage.TestData.Entity
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
        @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = {dat.TestPackage.TestData.OperationType.UPDATE}, dependsOn = {dat.TestPackage.TestData.Entity.class})
        public static void
        putEntity(dat.TestPackage.TestData.Entity value)
        {
            // Update the global entity reference
            globalEntity = value;
        }

        /**
         * Retrieves the globally stored Record class reference.
         *
         * @return The current global Record class, or null if no Record has been created
         */
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.READ)
        public static dat.TestPackage.TestData.Record
        getRecord()
        {
            return globalRecord;
        }

        /**
         * Updates the global Record class reference.
         *
         * @param value The Record class to set as the global record
         */
        @dat.TestPackage.TestData.Annotation(requiresGlobalState = true, value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {dat.TestPackage.TestData.Record.class})
        public static dat.TestPackage.TestData.Record
        putRecord(dat.TestPackage.TestData.Record value)
        {
            // Update the global record reference
            globalRecord = value;
            return value;
        }

        // ########################{Record Methods}######################################
        /**
         * Creates a new Record with both ID and name.
         *
         * <p>Use this method when creating a record from persisted data that already has an ID.</p>
         *
         * @param id The unique identifier for the record
         * @param name The name for the record
         * @return A new Record instance with the specified ID and name
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = {java.lang.Integer.class, java.lang.String.class})
        public static dat.TestPackage.TestData.Record
        putRecord(java.lang.Integer id, java.lang.String name)
        {
            // Create and return a new Record with both ID and name
            return new dat.TestPackage.TestData.Record(id, name);
        }

        /**
         * Extracts the ID from a DataUnit (Record).
         *
         * <p>This method converts the record to an entity to retrieve the ID.
         * This is necessary because the Record structure stores ID differently than Entity.</p>
         *
         * @param record The DataUnit (expected to be a Record) to extract ID from
         * @return The ID of the record, or null if no ID exists
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.TestPackage.TestData.Record.class)
        public static java.lang.Integer
        getId(dat.TestPackage.TestData.DataUnit record)
        {
            // Cast DataUnit to Record
            // Convert Record to Entity to access ID field
            Entity entity = recordToEntity((Record) record);
            // Return the ID from the entity
            return entity.getId();
        }

        /**
         * Converts an Entity to a Record.
         *
         * <p>This transformation creates an immutable Record from a mutable Entity,
         * useful for transferring data between layers (e.g., from DAO to DTO).</p>
         *
         * @param entity The Entity to convert
         * @return A new Record containing the entity's ID and name
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.TestPackage.TestData.Entity.class)
        public static dat.TestPackage.TestData.Record
        entityToRecord(dat.TestPackage.TestData.Entity entity)
        {
            // Create new Record from entity's ID and name fields
            return new dat.TestPackage.TestData.Record(entity.id, entity.name);
        }

        /**
         * Retrieves the name from the global Record.
         *
         * <p>This method accesses the name field of the most recently created Record
         * by calling the record's name() accessor method.</p>
         *
         * @return The name of the global record
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.READ, dataUnitType = {dat.TestPackage.TestData.DataType.RECORD})
        public static java.lang.String
        getRecordName()
        {
            // Call the Record's name() accessor (auto-generated by record declaration)
            dat.TestPackage.TestData.Record result = getGlobalRecord();
            return result.name();
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
        @dat.TestPackage.TestData.Annotation(   dataUnitType    = dat.TestPackage.TestData.DataType.ENTITY,
                                                dependsOn       = { java.lang.String.class,
                                                                    java.lang.Integer.class})
        public static dat.TestPackage.TestData.Entity
        putEntity(java.lang.String name, java.lang.Integer id)
        {
            // Create new Entity (id parameter is not used)
            return new dat.TestPackage.TestData.Entity(name);
        }

        /**
         * Retrieves the name from the global Entity.
         *
         * <p>This method directly accesses the static name field of the global entity class.</p>
         *
         * @return The name of the global entity
         */
        @dat.TestPackage.TestData.Annotation(dataUnitType = dat.TestPackage.TestData.DataType.ENTITY)
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
        @dat.TestPackage.TestData.Annotation(value          = {dat.TestPackage.TestData.OperationType.READ},
                                            dataUnitType    = {dat.TestPackage.TestData.DataType.ENTITY},
                                            dependsOn       = {dat.TestPackage.TestData.Entity.class})
        public static java.lang.Integer
        getId(dat.TestPackage.TestData.Entity entity)
        {
            // Return the ID field from the entity
            return entity.id;
        }

        /**
         * Converts a Record to an Entity.
         *
         * <p>This transformation creates a mutable Entity from an immutable Record,
         * useful when preparing to persist data or when modification is needed.</p>
         *
         * <p><b>Note:</b> The Record's ID is not transferred to the Entity.
         * The Entity will have a null ID until persisted.</p>
         *
         * @param record The Record to convert
         * @return A new Entity containing the record's name
         */
        @dat.TestPackage.TestData.Annotation(   value = {dat.TestPackage.TestData.OperationType.READ},
                                                dataUnitType = {dat.TestPackage.TestData.DataType.ENTITY},
                                                dependsOn = {dat.TestPackage.TestData.Record.class})
        public static dat.TestPackage.TestData.Entity
        recordToEntity(dat.TestPackage.TestData.Record record)
        {
            // Create new Entity from record's name (ID is not transferred)
            return new dat.TestPackage.TestData.Entity(record.name());
        }
    }

    /**
     * Record is an immutable data structure for transferring data between application layers.
     *
     * <p><b>Immutability:</b> As a Java record, all fields are final and cannot be modified
     * after construction. To change values, create a new Record instance.</p>
     *
     * <p><b>Purpose:</b> Records serve as data carriers between Methods, Fields, and Classes,
     * providing a type-safe way to move data without allowing mutation.</p>
     *
     * <p><b>Auto-registration:</b> Upon construction, automatically registers itself
     * as the global record through Methods.putGlobalRecord().</p>
     *
     * @param id The unique identifier (may be null for unpersisted records)
     * @param name The name/label for this record
     * @param record The DataType enum value (always RECORD for this type)
     */
    @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR)
    record Record(java.lang.Integer id, java.lang.String name, dat.TestPackage.TestData.DataType record) implements DataUnit
    {
        /**
         * Constructs a Record with only a name (ID will be null).
         *
         * <p>Delegates to the canonical constructor with null ID and RECORD type,
         * then registers itself as the global record.</p>
         *
         * @param name The name for this record
         */
        @dat.TestPackage.TestData.Annotation( value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR, dependsOn = {java.lang.String.class})
        private Record(java.lang.String name)
        {
            // Call canonical constructor with null ID
            this(null,name, dat.TestPackage.TestData.DataType.RECORD);
            // Register this record as the global record
            dat.TestPackage.TestData.Methods.putRecord(this);
        }

        /**
         * Constructs a Record with both ID and name.
         *
         * <p>Delegates to the canonical constructor with the RECORD type,
         * then registers itself as the global record.</p>
         *
         * @param id The unique identifier for this record
         * @param name The name for this record
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CONSTRUCTOR, dependsOn = {java.lang.String.class, java.lang.Integer.class})
        private Record(java.lang.Integer id, java.lang.String name)
        {
            // Call canonical constructor with provided ID and name
            this(id, name, dat.TestPackage.TestData.DataType.RECORD);
            // Register this record as the global record
            dat.TestPackage.TestData.Methods.putRecord(this);
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
    @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.INTERFACE)
    private interface Interface<ID extends java.io.Serializable>
    {
        /**
         * Retrieves the unique identifier for this object.
         *
         * <p>Used for identity validation and tracking.</p>
         *
         * @return The unique identifier
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.IDENTIFIER, requiresGlobalState = true)
        ID getId();

        /**
         * Checks if the specified role has read permission.
         *
         * @param role The user role to check
         * @return true if the role can read, false otherwise
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.READ, dependsOn = dat.Security.entities.Role.class)
        boolean canRead(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has write permission.
         *
         * @param role The user role to check
         * @return true if the role can write, false otherwise
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.WRITE, dependsOn = dat.Security.entities.Role.class)
        boolean canWrite(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has delete permission.
         *
         * @param role The user role to check
         * @return true if the role can delete, false otherwise
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.DELETE, dependsOn = dat.Security.entities.Role.class)
        boolean canDelete(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has update permission.
         *
         * @param role The user role to check
         * @return true if the role can update, false otherwise
         */
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.UPDATE, dependsOn = dat.Security.entities.Role.class)
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
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.VALIDATOR, requiresGlobalState = true)
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
        @dat.TestPackage.TestData.Annotation(value = dat.TestPackage.TestData.OperationType.CRUD_VALIDATOR, dependsOn = {dat.Security.entities.Role.class, java.lang.String.class})
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
        dat.TestPackage.TestData.OperationType[] value() default {dat.TestPackage.TestData.OperationType.UNKNOWN};

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
        dat.TestPackage.TestData.DataType[] dataUnitType() default {};

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
        RECORD;
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
