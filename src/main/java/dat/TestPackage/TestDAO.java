package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

import dat.Blueprint.DAO.AbstractDAO;
import dat.Blueprint.DAO.InterfaceDAO;
import dat.Blueprint.Exception.ApiException;
import dat.Blueprint.Factory.AbstractFactory;
import dat.Enum.ErrorTypes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public final class TestDAO {
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

    public abstract class AbstractDAO<  Entity  extends         dat.Instance.Entity.Entity,
                                        DTO     extends         dat.Instance.DTO.DTO,
                                        ID      extends         Serializable> extends AbstractFactory<Entity, DTO, ID>
                                        implements InterfaceDAO<Entity, ID>
    {
        private static final Logger log = LoggerFactory.getLogger(dat.Blueprint.DAO.AbstractDAO.class);
        public EntityManagerFactory emf;

        public AbstractDAO(EntityManagerFactory     emf,
                           Class<Entity>            entityClass,
                           Class<DTO>               dtoClass,
                           Class<ID>                idClass){
            super(entityClass,dtoClass, idClass);
            this.emf = emf;
        }

    @Override
    public Class<Entity> getEntityClass(){
        return this.entityClass;
    }

        @Override
        public Entity get(ID id){
            log.debug("Reading/finding entity with id {}", id);
            try (EntityManager em = emf.createEntityManager()){
                String jpql = "SELECT a FROM " + entityClass.getName() + " a WHERE a.id = :id";
                Entity entity = em.createQuery(jpql, entityClass)
                        .setParameter("id", id)
                        .getSingleResult();
                log.debug("Found entity with id {}", id);
                return entity;
            } catch (NoResultException e) {
                log.debug("No entity found  with ID: {}", id);
                throw new ApiException(ErrorTypes.NOT_FOUND, "Database error: " + e.getMessage());
            } catch (Exception e){
                log.error("Error finding entity with ID: {}",  id, e);
                throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
            }
        }

        @Override
        public List<Entity> getAllEntities(){
            log.debug("Retrieving all entities");
            try (EntityManager em = emf.createEntityManager()){
                String jpql = "SELECT  a FROM " + entityClass.getSimpleName() + " a";
                List<Entity> result =  em.createQuery(jpql, entityClass).getResultList();
                log.info("Retrieved {} entities ", result.size());
                return result;
            } catch (Exception e) {
                log.error("Error retrieving all", e);
                throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error: " + e.getMessage());
            }
        }

        @Override
        public Entity post(Entity entity){
            log.debug("Creating a new entity");
            try (EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                log.info("Successfully created a entity");
                return entity;
            } catch (Exception e){
                log.error("Failed to create entity",  e);
                throw new ApiException(ErrorTypes.SERVER_ERROR, "Failed to create entity: " + e.getMessage());
            }
        }

        @Override
        public Entity put(ID id, Entity entity){
            log.debug("Updating entity  with Id: {}", id);
            if (id == null || entity == null){
                return null;
            }
            try (EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                Entity existing = em.find(entityClass, id);
                if (existing == null){
                    log.warn("Entity not found for update with Id: {}", id);
                    em.getTransaction().rollback();
                    return null;
                }
                Entity result = em.merge(entity);
                em.getTransaction().commit();
                log.info("Successfully updated entity with Id: {}", id);
                return result;
            }
        }

        @Override
        public void delete(ID id){
            log.debug("Deleting entity  with Id: {}", id);
            try (EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                String jpql =  "DELETE FROM " + entityClass.getName() + " a WHERE a.id = :id";
                int deletedCount = em.createQuery(jpql)
                        .setParameter("id", id)
                        .executeUpdate();
                if (deletedCount > 0) {
                    log.info("Successfully deleted entity with Id: {}", id);
                } else {
                    log.warn("No entity found to delete with Id: {}", id);
                }
            } catch (Exception e) {
                log.error("Error deleting entity with Id: {}",  id, e);
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
        public Entity executeJPQL(String jpql, Map<String, Object> params)
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
                return result;
            } catch (NoResultException e){
                log.debug("No result found for JPQL query = {}", jpql);
                return null;
            } catch (Exception e){
                log.error("Error happened while executing JPQL query: {}", jpql);
                throw new ApiException(ErrorTypes.SERVER_ERROR, "Database error has happen: " + e.getMessage());
            }
        }
    }

}

