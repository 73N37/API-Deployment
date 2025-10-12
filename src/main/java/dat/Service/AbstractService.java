package dat.Services;
import dat.Enums.ErrorTypes;
import dat.Annotations.IgnoreMapping;
import dat.Annotations.MapTo;
import dat.DAOs.InterfaceDAO;
import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;
import dat.Exceptions.ApiException;
import dat.Factories.AbstractFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
getDeclaredConstructor is part of Java's reflection API. You call in with this syntax "class.getDeclaredConstructor()" and it returns a java.lang.reflect.Constructor<T>.
newInstance is a part of Java's reflection API. You call with this syntax "Constructor.newInstance()" and it returns an Object (instance of a class).

NOTE:
“Declared” means any visibility (public, protected, package, private) but only constructors declared in that class (constructors aren’t inherited anyway)

Field is a part of Java's reflection API. A Field object is metadata + access handle for a single member field (instance or static) of a class.

Field Introspect:
- getName(): get the name of the variable as a String.
- getAnnotation(Class<T> annotationClass): get a single annotation for a given Field.
- getAnnotations(): get the annotations for a given Field (datatype is Annotation[]).
- getType(): get a datatype
- getSimpleName(): returns the package path of a class

If a Field is not public you must execute command "field.setAccessible(true)" before assigning a Field to avoid access errors (IllegalArgumentException).
If a Field is final (especially static final)assume the Field is immutable.
Field Access:
- get(Object target): receive the assigned value of a Field as an Object.
- set(Object target, Object value): assign a value to a Field. Fx. set(String name, "73N37").

Field[] is an array of the datatype Field. Arrays are covariant in Java (a Field[] is also an Object[]), so be careful not to write the wrong type through an Object[] alias (that would throw ArrayStoreException)
Field[]:
- class.getDeclaredFields(): Iterates through EVERY (public, protected, private, package) Field in a class and adds them to an Array (datatype is Field[]). Order is unspecified: don’t rely on array order being source order; sort if you care
- class.getFields(): Iterates through ONLY public Fields in a class and adds them to an Array (datatype Field[]): Order is unspecified: don’t rely on array order being source order; sort if you care
            */

public abstract class AbstractService<  Entity  extends AbstractEntity,
                                        DTO     extends AbstractDTO,
                                        ID      extends Serializable>
                                                extends AbstractFactory<      Entity, DTO, ID>
                                                implements InterfaceService<Entity, DTO, ID>
{
    private static final Logger log = LoggerFactory.getLogger(AbstractService.class);
    protected final InterfaceDAO<Entity, DTO,ID> dao;

    public AbstractService(InterfaceDAO<Entity, DTO, ID>dao,
                           Class<Entity>                entityClass,
                           Class<DTO>                   dtoClass,
                           Class<ID>                    idClass)
    {
        super(entityClass, dtoClass, idClass);
        this.dao = dao;
    }

    @Override
    public Set<Entity> readAllEntity(){
        // Uses Set<> on the readAll() method from DAO to remove all duplicate entries
        log.debug("Retrieving all {} entities in database and removing duplicates", entityClass);
        List<Entity> databaseEntries = dao.readAll();
        return databaseEntries.
                stream().
                collect(Collectors.toSet());
    }

    @Override
    public Set<DTO> readAllDTO(){
        // Making my Set<Entity> into a Set<DTO>
        log.debug("Transforming my Set<Entity> to a Set<DTO>", dtoClass);
        Set<Entity> entitySet = readAllEntity();
        return entitySet
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toSet());

    }

    @Override
    public Entity dtoToEntity(DTO dto){
        if (dto == null){
            return null;
        }
        try {
            Entity entity = entityClass.getDeclaredConstructor().newInstance();
            Field[] dtoFields = dto.getClass().getDeclaredFields();
            for (Field dtoField : dtoFields) {

                // Skips a field in the annotation @IgnoreMapping is present above a given field
                if(dtoField.isAnnotationPresent(IgnoreMapping.class)){

                    // continues the for-each loop without doing anything
                    continue;
                }

                // Makes field accessable for the next command
                dtoField.setAccessible(true);
                Object value = dtoField.get(dto);

                String targetFieldName = dtoField.getName();

                // Check if field has @MapTo annotation
                if (dtoField.isAnnotationPresent(MapTo.class)){
                    targetFieldName = dtoField.getAnnotation(MapTo.class).value();
                }
                try {
                    Field entityField = entityClass.getDeclaredField(targetFieldName);
                    entityField.setAccessible(true);
                    entityField.set(entity, value);
                } catch (IllegalAccessException e) {
                    log.error("method failed since no matching method [newInstance()] was found");
                } catch (NoSuchFieldException e){
                    log.debug("Field {} not found in entity {}", targetFieldName, entityClass.getSimpleName());
                }
            }
            return entity;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DTO entityToDTO(Entity entity){
        if (entity == null){
            return null;
        }
        try{
            /*
            getDeclaredConstructor is part of Java's reflection API. You call in with this syntax "class.getDeclaredConstructor()" and it returns a java.lang.reflect.Constructor<T>.
            newInstance is a part of Java's reflection API. You call with this syntax "Constructor.newInstance()" and it returns an Object (instance of a class).

            NOTE:
            “Declared” means any visibility (public, protected, package, private) but only constructors declared in that class (constructors aren’t inherited anyway)
            */

            // - class.getDeclaredFields(): Iterates through EVERY (public, protected, private, package) Field in a class and adds them to an Array (datatype is Field[]). Order is unspecified: don’t rely on array order being source order; sort if you care
            DTO dto = dtoClass.getDeclaredConstructor().newInstance();
            Field[] entityFields = entity.getClass().getDeclaredFields();
            for (Field entityField : entityFields ){

                // Skips a field in the annotation @IgnoreMapping is present above a given field
                if(entityField.isAnnotationPresent(IgnoreMapping.class)){
                    // continues the for-each loop without doing anything
                    continue;
                }
                entityField.setAccessible(true);
                Object value = entityField.get(entity);
                try{
                    Field dtoField = dto.getClass().getDeclaredField(entityField.getName());
                    dtoField.setAccessible(true);
                    dtoField.set(dto, value);
                } catch (IllegalAccessException e) {
                    log.error("method failed since no matching method [newInstance()] was found");
                } catch (NoSuchFieldException e){
                    log.debug("Field {} not found in DTO {}", entityField.getName(), entityClass.getSimpleName());
                }
            }
            return dto;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DTO create(DTO dto)
    {
        log.debug("Creating a new entry in database from a DTO = {}", dtoClass.getSimpleName());
        if (dto == null){
            log.error("DTO is null");
            throw new ApiException(ErrorTypes.BAD_REQUEST, "DTO is null");
        }
        try {
            Entity entity = dtoToEntity(dto);
            if(entity == null){
                log.error("Entity is null");
                throw new ApiException(ErrorTypes.BAD_REQUEST, "Failed to convert DTO to Entity");
            }
            Entity databaseEntry = dao.create(entity);
            log.info("Successfully add this {} as a new entry in the database ", databaseEntry.getClass().getSimpleName());;
            return entityToDTO(databaseEntry);
        } catch (ApiException e) {
            throw e;
        } catch (Exception e){
            log.error("Error while adding this {} as a new entry in the database", e.getMessage());
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    @Override
    public DTO read(ID id){
        log.debug("Fetching database entry with id {}", id);
        Optional<Entity> readEntry = dao.read(id);
        if (readEntry.isPresent()) {
            return entityToDTO(readEntry.get());
        }
        return null;
    }

    @Override
    public DTO update(ID id, DTO dto){
        log.debug("Updating database entry with id {}", id);
        Optional<Entity> updateEntry = dao.update(id, dtoToEntity(dto));
        if(updateEntry.isPresent()){
            return entityToDTO(updateEntry.get());
        }
        return null;
    }

    @Override
    public void delete(ID id){
        log.debug("Deleting database entry (DTO) with id {}", id);
        dao.delete(id);
    }

    @Override
    public void delete(Entity entity){
        log.debug("Deleting database entry (Entity) with id {}", entity.getId());
        ID id = null;
        try{
            id = (ID) entity.getId();
        } catch (ClassCastException e){
            log.error("Error happen when typecasting {} to ID while deleting with entity as parameter. ", Serializable.class);
        }
        dao.delete(id);
    }

    @Override
    public DTO read(Entity entity){
        ID id = null;
        try {
            id = (ID) entity.getId();
        } catch(ClassCastException e){
            log.error("Error happen when typecasting {} to ID while reading entity as parameter", Serializable.class);
        }
        log.debug("Fetching database entry (entity) with id {}", id);
        Optional<Entity> readEntry = dao.read(id);
        if (readEntry.isPresent()) {
            return entityToDTO(readEntry.get());
        }
        return null;
    }
}
