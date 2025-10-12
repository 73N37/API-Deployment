package dat.DAO.impl;

import dat.Enum.ErrorTypes;
import dat.DAO.InterfaceDAO;
import dat.DTO.AbstractDTO;
import dat.Entity.AbstractEntity;
import dat.Exception.ApiException;
import dat.Factory.AbstractFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDAO<  Entity  extends         AbstractEntity<Entity, ID>,
                                    DTO     extends         AbstractDTO<DTO, ID>,
                                    ID      extends         Serializable> extends AbstractFactory<Entity, DTO, ID>
                                            implements      InterfaceDAO<Entity, DTO, ID>
{
    private static final Logger log = LoggerFactory.getLogger(AbstractDAO.class);
    public EntityManagerFactory emf;

    public AbstractDAO(EntityManagerFactory emf,
                       Class<Entity> entityClass,
                       Class<DTO> dtoClass,
                       Class<ID> idClass){
        super(entityClass,dtoClass, idClass);
        this.emf = emf;
    }

    @Override
    public Class<Entity> getEntityClass(){
        return this.entityClass;
    }

    @Override
    public Optional<Entity> read(ID id){
        log.debug("Reading/finding entity with id {}", id);
        try (EntityManager em = emf.createEntityManager()){
            String jpql = "SELECT a FROM " + entityClass.getName() + " a WHERE a.id = :id";
            Entity entity = em.createQuery(jpql, entityClass)
                            .setParameter("id", id)
                            .getSingleResult();
            log.debug("Found entity with id {}", id);
            return Optional.of(entity);
        } catch (NoResultException e) {
            log.debug("No entity found of type: {} with Object: {}", entityClass.getSimpleName(), id);
            throw new ApiException(ErrorTypes.NOT_FOUND, "Database error: " + e.getMessage());
        } catch (Exception e){
            log.error("Error finding entity of type: {} with Object: {}", entityClass.getSimpleName(), id, e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Entity> readAll(){
        log.debug("Retrieving all entities of type: {}", entityClass.getSimpleName());
        try (EntityManager em = emf.createEntityManager()){
            String jpql = "SELECT  a FROM " + entityClass.getSimpleName() + " a";
            List<Entity> result = em.createQuery(jpql, entityClass).getResultList();
            log.info("Retrieved {} entities of type: {} in {} ms",
                    result.size(), entityClass.getSimpleName());
            return result;
        } catch (Exception e) {
            log.error("Error retrieving all entities of type: {}", entityClass.getSimpleName(), e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    @Override
    public Entity create(Entity entity){
        log.debug("Creating a new entity of type {}",  entityClass.getSimpleName());
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            log.info("Successfully created a entity of type {}",  entityClass.getSimpleName());
            return entity;
        } catch (Exception e){
            log.error("Failed to create entity of type: {}", entityClass.getSimpleName(), e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Failed to create entity: " + e.getMessage());
        }
    }

    @Override
    public Optional<Entity> update(ID id, Entity entity){
        log.debug("Updating entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
        if (id == null || entity == null){
            return null;
        }
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Entity existing = em.find(entityClass, id);
            if (existing == null){
                log.warn("Entity not found for update of type: {} with Object: {}", entityClass.getSimpleName(), id);
                em.getTransaction().rollback();
                return null;
            }
            Entity result = em.merge(entity);
            em.getTransaction().commit();
            log.info("Successfully updated entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
            return Optional.of(result);
        }
    }

    @Override
    public void delete(ID id){
        log.debug("Deleting entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            String jpql =  "DELETE FROM " + entityClass.getName() + " a WHERE a.id = :id";
            int deletedCount = em.createQuery(jpql)
                    .setParameter("id", id)
                    .executeUpdate();
            if (deletedCount > 0) {
                log.info("Successfully deleted entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
            } else {
                log.warn("No entity found to delete of type: {} with Object: {}", entityClass.getSimpleName(), id);
            }
        } catch (Exception e) {
            log.error("Error deleting entity of type: {} with Object: {}", entityClass.getSimpleName(), id, e);
        }
    }

    @Override
    public boolean validatePrimaryKey(ID id){
        try (EntityManager em = emf.createEntityManager()) {
            Entity entity = em.find(entityClass, id);
            return entity != null;
        }
    }

    @Override
    public Optional<Entity> executeJPQL(String jpql, Map<String, Object> params)
    { // TODO Set MODERATOR access ONLY
        log.debug("Executing a custom JPQL query");
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery query = em.createQuery(jpql, entityClass);
            // set all parameter from the Map
            if (params != null)
            {
                for (Map.Entry<String, Object> entry : params.entrySet())
                {
                    query.setParameter(entry.getKey(), entry.getValue());
                    log.debug("Set parameter {} = {}", entry.getKey(), entry.getValue());
                }
            }
            Entity result = (Entity) query.getSingleResult();
            log.debug("Successfully executes JPQL query");
            return Optional.of(result);
        } catch (NoResultException e){
            log.debug("No result found for JPQL query = {}", jpql);
            return Optional.empty();
        } catch (Exception e){
            log.error("Error happened while executing JPQL query: {}", jpql);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error has happen: " + e.getMessage());
        }
    }
}
