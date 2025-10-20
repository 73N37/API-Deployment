package dat.Package;



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
public final class Information extends Utilization
{   // Information [class] begins
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Information.class);

    private static final java.util.concurrent.atomic.AtomicInteger idCounter = new java.util.concurrent.atomic.AtomicInteger(0);

    private static dat.Package.Information.Entity   globalEntity;
    private static dat.Package.Information.DTO      globalDTO;
    private static dat.Package.Information          instance;

    private Information(){}

    private static dat.Package.Information
    get()
    {   // get() [method] begins
        return (instance == null) ? new Information() : instance;   // Singleton pattern, returns instance of Information
    }   // get() [method] ends


    public class
    Data
    {   // Data [class] begins
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Data.class);

        public void
        clearGlobalState()
        {
            globalEntity    = null;
            globalDTO       = null;
        }

        public dat.Package.Information
        getInstance(dat.Package.Utilization.Role role)
        {   // getInstance(Role) [method] begins
            try
            {   // try-block [conditional] begins
                log.debug("Checking user access");
                boolean accept = dat.Package.Utilization.Role.isAccessAllowed(role, dat.Package.Utilization.Role.USER);
                log.debug("Access was GRANTED");
                return (accept) ? dat.Package.Information.get() : null;
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("An error happen while either granting user access or returning the instance of {}", dat.Package.Information.class, e);
                return null;
            }   // catch-block [conditional] ends
        }   // getInstance(Role) [method] begins

        public dat.Package.Information.DTO
        getDTO(dat.Package.Utilization.Role role)
        {   // getDTO(Role) [method] begins
            try
            {   // try-block [conditional] begins
                log.debug("Checking user access");
                boolean accept = dat.Package.Utilization.Role.isAccessAllowed(role, dat.Package.Utilization.Role.ANYONE);
                log.debug("Access was GRANTED");
                return (accept) ? dat.Package.Information.globalDTO : null;
            }   // try-block [conditional] ends
            catch (Exception e)
            {   // catch-block [conditional] begins
                log.error("An error happen while either granting user access or returning the instance of {}", dat.Package.Information.DTO.class, e);
                return null;
            }   // catch [conditional] ends
        }   // getDTO(Role) [method] ends


        public dat.Package.Information.Entity
        getEntity
                (
                        java.lang.Integer               id,
                        dat.Package.Utilization.Role    role
                )
        {
            boolean accept = dat.Package.Utilization.Role.isAccessAllowed(role, dat.Package.Utilization.Role.USER);
            return (accept) ? dat.Package.Information.EntityRepository.get(id) : null;
        }

        public dat.Package.Information.Entity
        putEntity
                (
                        java.lang.String                name,
                        dat.Package.Utilization.Role    role
                )
        {
            boolean accept = dat.Package.Utilization.Role.isAccessAllowed(role, dat.Package.Utilization.Role.USER);
            return (accept) ? dat.Package.Information.EntityRepository.put(new dat.Package.Information.Entity(name)) : null;
        }

        public void
        deleteEntity
                (
                        dat.Package.Information.Entity entity
                )
        {
            dat.Package.Information.EntityRepository.delete(entity);
        }

        public void
        deleteEntity
                (
                        java.lang.Integer id
                )
        {
            dat.Package.Information.EntityRepository.delete(id);
        }

        public java.lang.String
        getName
                (   // Arguments begins
                        dat.Package.Information.DataUnit dataUnit
                )   // Arguments ends
        {   // getName(instanceof) [method] begins
            if (dataUnit.equals(dat.Package.Information.Entity.class)) return dataUnit.getName();
            if (dataUnit.equals(dat.Package.Information.DTO.class)) return dataUnit.getName();
            else return null;
        }   // getName(instanceof) [method] ends

        public java.lang.Integer
        getId
                (   // Arguments begins
                    dat.Package.Information.DataUnit dataUnit
                )   // Arguments ends
        {   // getId(DataUnit) [method] begins
            if (dataUnit.equals(dat.Package.Information.Entity.class)) return dataUnit.getId();
            if (dataUnit.equals(dat.Package.Information.DTO.class)) return dataUnit.getId();
            else return null;
        }   // getId(DataUnit) [method] begins
    }   // Data [class] ends

    private static abstract class
    DataUnit
    {
        protected java.lang.Integer id;
        protected java.lang.Integer
        getId()
        {
                return this.id;
        }

        protected java.lang.String name;
        protected java.lang.String
        getName()
        {
            return this.name;
        }
    }

    private static class
    Entity extends DataUnit
    {   // Entity [class] begins
        private Entity
                (
                        java.lang.Integer   id,
                        java.lang.String    name
                )
        {   // Entity [constructor] begins
            this.id = id;
            this.name = name;
            globalEntity = this;
        }   // Entity [constructor] ends

        private Entity
                (
                        java.lang.String name
                )
        {   // Entity [constructor] begins
            this.name = name;
            this.id = idCounter.incrementAndGet();
            globalEntity = this;
        }   // Entity [constructor] ends
    }   // Entity [class] ends

    private static class
    DTO extends DataUnit
    {   // DTO [class] begins
        private DTO
                (
                        java.lang.Integer id,
                        java.lang.String name
                )
        {
            this.id = id;
            this.name = name;
            globalDTO = this;
        }

        private DTO
                (
                        java.lang.String name
                )
        {
            this.name = name;
            this.id = idCounter.incrementAndGet();
        }
    }   // DTO [class] ends


    private static class
    EntityRepository
    {
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EntityRepository.class);
        private static dat.Package.Information.Entity
        put(dat.Package.Information.Entity entity)
        {
            final jakarta.persistence.EntityManager  em = dat.Package.Utilization.emf.createEntityManager();
            try
            {
                log.debug("Attempting to persist and entity");
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                log.debug("Successfully persisted Entity={}", entity);
                return entity;
            } catch (Exception e){
                em.getTransaction().rollback();
                log.error("An error happen while attempting to persist entity={}", entity, e);
                return null;
            }
        }

        private static dat.Package.Information.Entity
        get(java.lang.Integer id)
        {
            final jakarta.persistence.EntityManager  em = dat.Package.Utilization.emf.createEntityManager();
            try {
                log.debug("Attempting to find an entity by ID");
                em.getTransaction().begin();
                dat.Package.Information.Entity result = em.find(dat.Package.Information.Entity.class, id);
                em.getTransaction().commit();
                log.debug("Successfully found an entity by ID ");
                return result;
            } catch (Exception e)
            {
                log.error("Was unable to find an entity by this ID={}", id, e);
                return null;
            }
        }

        private static void
        delete(dat.Package.Information.Entity entity)
        {
            final jakarta.persistence.EntityManager  em = dat.Package.Utilization.emf.createEntityManager();
            try{
                log.debug("Attempting to delete this Entity={}", entity);
                em.getTransaction().begin();
                em.remove(entity);
                em.getTransaction().commit();
            } catch (Exception e){
                log.error("An erroe happen while trying to delete this Entity={}", entity, e);
            }
        }

        private static void
        delete(java.lang.Integer id)
        {
            try{
                log.debug("Attempting to to delete an Entity by ID={}", id);
                dat.Package.Information.Entity entity = dat.Package.Information.EntityRepository.get(id);
                dat.Package.Information.EntityRepository.delete(entity);
                log.debug("Successfully delete Entity=", entity);
            } catch (Exception e){
                log.error("An error happen while trying to delete an Entity with ID=", id,e);
            }
        }
    }
}   //  Information [class] ends
