package dat.daos.impl;

import dat.Enums.ErrorTypes;
import dat.daos.InterfaceDAO;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.exceptions.ApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<  Entity  extends         AbstractEntity<Entity>,
                                    DTO     extends         AbstractDTO<DTO>,
                                    ID      extends         Serializable>
                                            implements      InterfaceDAO<Entity, DTO, ID>
{
    private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
    protected EntityManagerFactory emf;
    protected final Class<Entity> entityClass;

    public AbstractDAO(EntityManagerFactory emf,
){
        this.emf = emf;
        this.entityClass = entityClass;
    }

    @Override
    public Class<Entity> getEntityClass(){
        return this.entityClass;
    }

    @Override
    public Optional<Entity> read(ID id){
        logger.debug("Reading/finding entity with id {}", id);
        try (EntityManager em = emf.createEntityManager()){
            String jpql = "SELECT a FROM " + entityClass.getName() + " a WHERE a.id = :id";
            Entity entity = em.createQuery(jpql, entityClass)
                            .setParameter("id", id)
                            .getSingleResult();
            logger.debug("Found entity with id {}", id);
            return Optional.of(entity);
        } catch (NoResultException e) {
            logger.debug("No entity found of type: {} with Object: {}", entityClass.getSimpleName(), id);
            throw new ApiException(ErrorTypes.NOT_FOUND, "Database error: " + e.getMessage());
        } catch (Exception e){
            logger.error("Error finding entity of type: {} with Object: {}", entityClass.getSimpleName(), id, e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Entity> readAll(){
        logger.debug("Retrieving all entities of type: {}", entityClass.getSimpleName());
        try (EntityManager em = emf.createEntityManager()){
            String jpql = "SELECT  a FROM " + entityClass.getSimpleName() + " a";
            List<Entity> result = em.createQuery(jpql, entityClass).getResultList();
            logger.info("Retrieved {} entities of type: {} in {} ms",
                    result.size(), entityClass.getSimpleName());
            return result;
        } catch (Exception e) {
            logger.error("Error retrieving all entities of type: {}", entityClass.getSimpleName(), e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }

    @Override
    public Entity create(Entity entity){
        logger.debug("Creating a new entity of type {}",  entityClass.getSimpleName());
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            logger.info("Successfully created a entity of type {}",  entityClass.getSimpleName());
            return entity;
        } catch (Exception e){
            logger.error("Failed to create entity of type: {}", entityClass.getSimpleName(), e);
            throw new ApiException(ErrorTypes.SERVER_ERROR, "Failed to create entity: " + e.getMessage());
        }
    }

    @Override
    public Optional<Entity> update(ID id, Entity entity){
        logger.debug("Updating entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
        if (id == null || entity == null){
            return null;
        }
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Entity existing = em.find(entityClass, id);
            if (existing == null){
                logger.warn("Entity not found for update of type: {} with Object: {}", entityClass.getSimpleName(), id);
                em.getTransaction().rollback();
                return null;
            }
            Entity result = em.merge(entity);
            em.getTransaction().commit();
            logger.info("Successfully updated entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
            return Optional.of(result);
        }
    }

    @Override
    public void delete(ID id){
        logger.debug("Deleting entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            String jpql =  "DELETE FROM " + entityClass.getName() + " a WHERE a.id = :id";
            int deletedCount = em.createQuery(jpql)
                    .setParameter("id", id)
                    .executeUpdate();
            if (deletedCount > 0) {
                logger.info("Successfully deleted entity of type: {} with Object: {}", entityClass.getSimpleName(), id);
            } else {
                logger.warn("No entity found to delete of type: {} with Object: {}", entityClass.getSimpleName(), id);
            }
        } catch (Exception e) {
            logger.error("Error deleting entity of type: {} with Object: {}", entityClass.getSimpleName(), id, e);
        }
    }

    @Override
    public boolean validatePrimaryKey(ID id){
        try (EntityManager em = emf.createEntityManager()) {
            Entity entity = em.find(entityClass, id);
            return entity != null;
        }
    }
}
