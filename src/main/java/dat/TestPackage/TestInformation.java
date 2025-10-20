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
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(dat.TestPackage.TestInformation.class);

    java.lang.Integer idCount;

    // The globalEntity is NOT the same Class as the Entity Class itself, since it is a layer above the Entity Object
    @dat.TestPackage.TestInformation.Annotation
            (
                            requiresGlobalState = true,
                            value               = dat.TestPackage.TestInformation.OperationType.FIELD
            )
    private static dat.TestPackage.TestInformation.Entity   globalEntity;

    /**
     * Global reference to the currently active DTO class.
     * This field stores the Class object of the most recently created DTO instance.
     * It acts as a registry layer above individual DTO objects for tracking purposes.
     *
     * <p>This field is accessed and modified exclusively through Methods class operations.</p>
     * <p>Lombok @Getter generates a private getter for this field.</p>
     */
    @dat.TestPackage.TestInformation.Annotation
            (
                            requiresGlobalState = true,
                            value               = dat.TestPackage.TestInformation.OperationType.FIELD
            )
    private static dat.TestPackage.TestInformation.DTO      globalDTO;



    @dat.TestPackage.TestInformation.Annotation
            (
                            requiresGlobalState = true,
                            value               = dat.TestPackage.TestInformation.OperationType.FIELD
            )
    private static dat.TestPackage.TestInformation          instance;

    /**
     * Private constructor to prevent direct instantiation.
     * Use getInstance() method to obtain the singleton instance.
     */
    @dat.TestPackage.TestInformation.Annotation
            (
                            requiresGlobalState = true
            )
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
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(dat.TestPackage.TestInformation.Data.class);
        // TODO: This class must be the factory for TestInformation [class],
        //       like Factory is to TestOperation [class]
//###############################################[TestInformation Methods]###############################################
        @dat.TestPackage.TestInformation.Annotation
                (
                            requiresGlobalState = true
                )
        public dat.TestPackage.TestInformation
        getInstance()
        {   // getInstance() [method] begins
            TestInformation instance = null;
            try
            {   // try-block [conditional] begins
                log.debug("Trying to get an instance of information");
                if (instance == null)
                {   // if-block [conditional] begins
                    log.debug("instance was null, so a new instantiation will be created and returned");
                    instance = new TestInformation();
                }   // if-block [conditional] ends
                log.debug("Successfully retrieved instance. Instance was NOT null, and will be returned");
                return instance;
            }   // try-block [conditional] ends
            catch (Exception e)
            {   //  catch-block [conditional] begins
                log.error("Failed to retrieve Information instance");
                return null;
            }   // catch-block [conditional] ends
        }   // getInstance() [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            requiresGlobalState = true,
                            value               = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public void clearGlobalState()
        {   // clearGlobalState() [method] begins
            try
            {   // try-block [conditional] begins
                globalEntity    = null;
                globalDTO       = null;
            }   //try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to set 'globalEntity & globalDTO to NULL");
            }   // catch-block [conditional] ends
        }   // clearGlobalState [method] ends




//###############################################[DTO Methods]###############################################
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public dat.TestPackage.TestInformation.DTO
        getDTO()
        {
            try
            {   // try-block [conditional] begins
                if (globalDTO != null) return globalDTO;
                return null;
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve any data from 'globalDTO'. Null will be returned");
                return null;
            }   // catch-block [conditional] ends
        }   // getDTO [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public java.lang.Integer
        getDtoId()
        {
            dat.TestPackage.TestInformation.DTO dto = null;
            try
            {   // try-block [conditional] begins
                try
                {   // try-block [conditional] begins
                    dto = getDTO();
                }   // try-block [conditional] ends
                catch (Exception e)
                {   // catch-block [conditional] begins
                    log.error("Was unable to retrieve a DTO");
                    return null;
                }   // catch-block [conditional] ends
                return dto.getId();
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve id from DTO={}", dto);
                return null;
            }   // catch-block [conditional] ends
        }   // getDtoId() [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public java.lang.String
        getDtoName()
        {   // getDtoName() [method] begins
            dat.TestPackage.TestInformation.DTO dto = null;
            try
            {   // try-block [conditional] begins
                try
                {   // try-block [conditional] begins
                    dto = getDTO();
                }   // try-block [conditional] ends
                catch (Exception e)
                {   // catch-block [conditional] begins
                    log.error("Was unable to retrieve a DTO");
                }   // catch-block [conditional] ends
                return dto.getName();
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve a name from DTO={}", dto);
                return null;
            }   // catch-block [conditional] ends
        }   // getDtoName() [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        public dat.TestPackage.TestInformation.DTO
        putDTO(java.lang.Integer id,
               java.lang.String name)
        {   // putDTO(Integer, String) [method] begins
            try
            {   // try-block [conditional] begins
                return new dat.TestPackage.TestInformation.DTO(id, name);
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to create a new instance of DTO");
                return null;
            }   // catch-block [conditional] ends
        }   // putDTO(Integer,String) [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        public dat.TestPackage.TestInformation.DTO
        putDTO(java.lang.String name)
        {   // putDTO(String) [method] begins
            try
            {   // try-block [conditional] begins
                return new dat.TestPackage.TestInformation.DTO(name);
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to create a new instance of DTO");
                return null;
            }   // catch-block [conditional] ends
        }   // putDTO(String [method] ends




//###############################################[Entity Methods]###############################################
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public dat.TestPackage.TestInformation.Entity
        getEntity()
        {
            try
            {   // try-block [conditional] begins
                if (globalEntity != null) return globalEntity;
                return null;
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve any data from 'globalDTO'. Null will be returned");
                return null;
            }   // catch-block [conditional] ends

        }   // getEntity() [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public java.lang.Integer
        getEntityId()
        {
            dat.TestPackage.TestInformation.Entity entity;
            try
            {   //try-block [conditional] begins
                entity = getEntity();
                try
                {   // try-block [conditional] begins
                    return entity.getId();
                }   // try-block [conditional] ends
                catch (Exception e)
                {   // catch-block [conditional] begins
                    log.error("Was unable to retrieve an id from entity={}", entity, e);
                    return null;
                }   // catch-block [conditional] ends
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve entity", e);
                return null;
            }   // catch-block [conditional] ends
        }   // getEntityId() [method] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public java.lang.String
        getEntityName()
        {
            dat.TestPackage.TestInformation.Entity entity;
            try
            {   // try-block [conditional] begins
                entity = getEntity();
                try
                {   // try [conditional] begins
                    return entity.getName();
                }   // try-block [conditional] ends
                catch  (Exception e)
                {   //catch-block [conditional] begins
                    log.error("Was unable to retrieve name from {} ", getEntity().getClass(), e);
                    return null;
                }   // catch-block [conditional] ends
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("Was unable to retrieve an entity");
                return null;
            }   // catch-block [conditional] ends
        }




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        public dat.TestPackage.TestInformation.Entity
        putEntity(java.lang.String name)
            // TODO: Overwrites the globalEntity Field
        {   // putEntity(String) [method] begins
            try
            {   // try-block [conditional] begins
                globalEntity = new dat.TestPackage.TestInformation.Entity(name);
                return globalEntity;
            } // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block  [conditional] begins
                log.error("Was unable to set 'globalEntity' param=[ DataType= {} : {}]",String.class, name, e);
                return null;
            }   // catch-block [conditional] ends
        }   // putEntity(String) [method]




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        public dat.TestPackage.TestInformation.Entity
        putEntity(java.lang.Integer id,
                  java.lang.String name)
        {
            return new dat.TestPackage.TestInformation.Entity(id, name);
        }




//###############################################[Converter Methods]###############################################
        @dat.TestPackage.TestInformation.Annotation
        (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
        )
        public dat.TestPackage.TestInformation.Entity
        dtoToEntity(dat.TestPackage.TestInformation.DTO dto)
        {
            return Methods.dtoToEntity(dto);
        }



        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        public dat.TestPackage.TestInformation.DTO
        entityToDTO(dat.TestPackage.TestInformation.Entity entity)
        {
            return Methods.entityToDTO(entity);
        }




        //###############################################[Validation Methods]###############################################
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.VALIDATOR
                )
        public boolean
        isEntityValid(Entity entity) {
            return entity != null && entity.getId() != null;
        }




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.VALIDATOR
                )
        public boolean
        isDTOValid(dat.TestPackage.TestInformation.DTO dto) {
            return dto != null && dto.getId() != null;
        }



        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.VALIDATOR
                )
        // Bulk operations
        public static java.util.List<dat.TestPackage.TestInformation.DTO> entitiesToDTOs(java.util.List<dat.TestPackage.TestInformation.Entity> entities) {
            return entities.stream()
                    .map(Methods::entityToDTO)
                    .collect(java.util.stream.Collectors.toList());
        }




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.VALIDATOR
                )
        public static java.util.List<dat.TestPackage.TestInformation.Entity> dtosToEntities(java.util.List<dat.TestPackage.TestInformation.DTO> dtos) {
            return dtos.stream()
                    .map(Methods::dtoToEntity)
                    .collect(java.util.stream.Collectors.toList());
        }
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




        protected java.lang.String name;
        protected java.lang.String getName()
        {   // getName() [method] begins
            return this.name;
        }   // getName() [method] ends




        protected java.lang.Integer id;
        java.lang.Integer getId()
        {   // getId() [method] begins
            return this.id;
        }   // getId() [method] ends




        @Override
        public java.lang.String toString() {
            return "ID = {" + getId() + "}, Name = {" + getName() + "}";
        }
    }




    @dat.TestPackage.TestInformation.Annotation
            (
                            value        = {dat.TestPackage.TestInformation.OperationType.CLASS},
                            dataUnitType = {dat.TestPackage.TestInformation.DataType.ENTITY}
            )
    protected static class Entity extends DataUnit
    {
        /**
         * Constructs a new Entity with the specified name.
         * Automatically registers this entity class as the global entity.
         *
         * @param name The name to assign to this entity
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            requiresGlobalState = true
                )
        Entity(java.lang.String name)
        {
            // Assign the provided name to the instance field
            this.name =     name;       // Uses inherited Field from DataUnit
            // Register this entity's class as the current global entity
            globalEntity =  this;
        }




        @dat.TestPackage.TestInformation.Annotation
                (
                            requiresGlobalState = true
                )
        Entity(java.lang.Integer id,
               java.lang.String name)
        {
            this.id = id;               // Uses inherited Field from DataUnit
            this.name = name;           // Uses inherited Field from DataUnit
            globalEntity = this;
        }
    }




    protected static class DTO extends DataUnit
    {
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        DTO(dat.TestPackage.TestInformation.Entity entity)
        {   // DTO [constructor] begins
            this.name = entity.name;
            globalDTO = this;
        }   // DTO [constructor] ends




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        DTO(java.lang.Integer   id,
            java.lang.String    name)
        {
            this.name = name;
            this.id = id;
            globalDTO = this;
        }




        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.CONSTRUCTOR
                )
        DTO(java.lang.String name)
        {
            this.name = name;
            globalDTO = this;
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
    @dat.TestPackage.TestInformation.Annotation
            (
                        requiresGlobalState = true,
                        value               = {dat.TestPackage.TestInformation.OperationType.CLASS}
            )
    private abstract static class
    Methods implements dat.TestPackage.TestInformation.Interface
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
         * @param type The Class object representing the type to instantiate (Entity or DTO)
         * @param <Data> The generic type parameter extending DataUnit
         * @return A new instance of the specified type
         * @throws IllegalArgumentException if the type cannot be instantiated (no accessible no-arg constructor)
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        private static <Data extends dat.TestPackage.TestInformation.DataUnit> Data
        create(java.lang.Class<Data> type) {
            try {
                // Uses reflection to invoke the no-argument constructor
                // This is necessary because Java's type erasure prevents 'new Data()'
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value = dat.TestPackage.TestInformation.OperationType.METHOD
                )
        private static java.lang.Class<? extends dat.TestPackage.TestInformation.DataUnit>
        getUnitClass(DataType type){
            // Check if the requested type is ENTITY
            if (type == dat.TestPackage.TestInformation.DataType.ENTITY) return dat.TestPackage.TestInformation.Entity.class;
            // Check if the requested type is DTO
            if (type == dat.TestPackage.TestInformation.DataType.DTO) return dat.TestPackage.TestInformation.DTO.class;
            // Return null for unrecognized types
            return null;
        }


        // ########################{Interface Methods}######################################
        @Override
        public java.io.Serializable
        getId()
        {
            if (globalEntity != null) return globalEntity.getId();
            if (globalDTO != null) return globalDTO.getId();
            return null;
        }



        @Override
        public boolean
        canRead(dat.Security.entities.Role role)
        {

        }



        @Override
        public boolean
        canWrite(dat.Security.entities.Role role)
        {

        }



        @Override
        public boolean
        canDelete(dat.Security.entities.Role role)
        {

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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.UPDATE},
                            dependsOn   = { java.lang.Integer.class,
                                            java.lang.String.class}
                )
        public static dat.TestPackage.TestInformation.DTO
        putDTO(
                java.lang.Integer id,
                java.lang.String name
        )
        {
            // Create and return a new DTO with both ID and name
            return new dat.TestPackage.TestInformation.DTO(id, name);
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.UPDATE},
                            dependsOn   = {dat.TestPackage.TestInformation.DTO.class}
                )
        public static java.lang.Integer
        getId(dat.TestPackage.TestInformation.DTO dto)
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
        @dat.TestPackage.TestInformation.Annotation
                (
                        value       = {dat.TestPackage.TestInformation.OperationType.UPDATE},
                        dependsOn   = {dat.TestPackage.TestInformation.Entity.class}
                )
        public static dat.TestPackage.TestInformation.DTO
        entityToDTO(dat.TestPackage.TestInformation.Entity entity)
        {
            // Create new DTO from entity's ID and name fields
            return new dat.TestPackage.TestInformation.DTO(entity.id, entity.name);
        }




        /**
         * Retrieves the name from the global DTO.
         *
         * <p>This method accesses the name field of the most recently created DTO
         * by calling the DTOs name() accessor method.</p>
         *
         * @return The name of the globalDTO
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value           = {dat.TestPackage.TestInformation.OperationType.READ},
                            dataUnitType    = {dat.TestPackage.TestInformation.DataType.DTO}
                )
        public static java.lang.String
        getDtoName()
        {
            // Call the DTOs name() accessor (auto-generated by DTO declaration)
            return new dat.TestPackage.TestInformation.Data().getDTO().getName();
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            dataUnitType    = { dat.TestPackage.TestInformation.DataType.ENTITY},
                            dependsOn       = { java.lang.String.class,
                                                java.lang.Integer.class}
                )
        public static dat.TestPackage.TestInformation.Entity
        putEntity(java.lang.String name, java.lang.Integer id)
        {
            // Create new Entity (id parameter is not used)
            return new dat.TestPackage.TestInformation.Entity(name);
        }





        /**
         * Retrieves the name from the global Entity.
         *
         * <p>This method directly accesses the static name field of the global entity class.</p>
         *
         * @return The name of the global entity
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            dataUnitType = {dat.TestPackage.TestInformation.DataType.ENTITY}
                )
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value           = {dat.TestPackage.TestInformation.OperationType.READ},
                            dataUnitType    = {dat.TestPackage.TestInformation.DataType.ENTITY},
                            dependsOn       = {dat.TestPackage.TestInformation.Entity.class}
                )
        public static java.lang.Integer
        getId(dat.TestPackage.TestInformation.Entity entity)
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value           = {dat.TestPackage.TestInformation.OperationType.READ},
                            dataUnitType    = {dat.TestPackage.TestInformation.DataType.ENTITY},
                            dependsOn       = {dat.TestPackage.TestInformation.DTO.class}
                )
        public static dat.TestPackage.TestInformation.Entity
        dtoToEntity(dat.TestPackage.TestInformation.DTO dto)
        {
            // Create new Entity from DTOs name (ID is transferred)
            return new dat.TestPackage.TestInformation.Entity(dto.getId(), dto.getName());
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
    @dat.TestPackage.TestInformation.Annotation
            (
                            value = {dat.TestPackage.TestInformation.OperationType.INTERFACE}
            )
    private interface Interface<ID extends java.io.Serializable>
    {
        /**
         * Retrieves the unique identifier for this object.
         *
         * <p>Used for identity validation and tracking.</p>
         *
         * @return The unique identifier
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value               = {dat.TestPackage.TestInformation.OperationType.IDENTIFIER},
                            requiresGlobalState = true
                )
        ID getId();

        /**
         * Checks if the specified role has read permission.
         *
         * @param role The user role to check
         * @return true if the role can read, false otherwise
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.READ},
                            dependsOn   = {dat.Security.entities.Role.class}
                )
        boolean canRead(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has write permission.
         *
         * @param role The user role to check
         * @return true if the role can write, false otherwise
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.WRITE},
                            dependsOn   = {dat.Security.entities.Role.class}
                )
        boolean canWrite(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has delete permission.
         *
         * @param role The user role to check
         * @return true if the role can delete, false otherwise
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.DELETE},
                            dependsOn   = {dat.Security.entities.Role.class}
                )
        boolean canDelete(dat.Security.entities.Role role);

        /**
         * Checks if the specified role has update permission.
         *
         * @param role The user role to check
         * @return true if the role can update, false otherwise
         */
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = {dat.TestPackage.TestInformation.OperationType.UPDATE},
                            dependsOn   = {dat.Security.entities.Role.class}
                )
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value               = {dat.TestPackage.TestInformation.OperationType.VALIDATOR},
                            requiresGlobalState = true
                )
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
        @dat.TestPackage.TestInformation.Annotation
                (
                            value       = { dat.TestPackage.TestInformation.OperationType.CRUD_VALIDATOR},
                            dependsOn   = { dat.Security.entities.Role.class,
                                            java.lang.String.class}
                )
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
        dat.TestPackage.TestInformation.OperationType[] value() default {dat.TestPackage.TestInformation.OperationType.UNKNOWN};

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
        dat.TestPackage.TestInformation.DataType[] dataUnitType() default {};

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
    private enum DataType
    {
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
