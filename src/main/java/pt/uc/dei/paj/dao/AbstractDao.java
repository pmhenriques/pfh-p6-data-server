package pt.uc.dei.paj.dao;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * This class accesses data of entities.
 * Uses EntityManager to persist data in database.
 *
 * @param <T> type of class
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AbstractDao<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -7630677551028811659L;

    private final Class<T> clazz;

    @Inject
    private EntityManager em;

    @Inject
    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Finds by primary key.
     * Searches for an entity of the specified class and primary key.
     * If the entity instance is contained in the persistence context,
     * it is returned from there.
     * Params:
     * entityClass – entity class
     * primaryKey – primary key (id)
     *
     * @param id primary key (id)
     * @return the found entity instance or null if the entity does not exist
     */
    public T find(Object id) {
        return em.find(clazz, id);
    }

    /**
     * Inserts a new register to the database.
     * Attaches the object to the entity manager.
     * To be used in add methods.
     *
     * @param entity entity
     */
    public void persist(final T entity) {
        em.persist(entity);
    }

    /**
     * Used to define queries with name in mapping file or annotation.
     * Executes a SELECT query and return the query results as a typed List.
     *
     * @return a list of the results
     */
    public List<T> findAll() {
        TypedQuery<T> q = em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz);
        return q.getResultList();
    }

    /**
     * Finds an attached object with the same id and update it.
     * If exists updates and return the already attached object.
     * If doesn't exist inserts the new register to the database.
     * To be used in update methods.
     *
     * @param entity entity
     */
    public void merge(final T entity) {
        em.merge(entity);
    }

    /**
     * Removes an attached object from the database.
     *
     * @param entity entity
     */
    public void delete(final T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * Obtains entity manager.
     *
     * @return entity manager em
     */
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Obtains the class type.
     *
     * @return class type
     */
    public Class<T> getClazz() {
        return clazz;
    }

    /**
     * Executes a single results from Entity Manager.
     *
     * @param q query that should result one single result
     * @return single result queried
     */
    protected T getSingleResult(TypedQuery<T> q) {

        return getSingleResult(q, clazz);
    }

    /**
     * Executes a single results from Entity Manager, catching the {@link NoResultException} and
     * returning null if the exception is thrown.
     *
     * @param q     query that should result one single result
     * @param clazz type of class to return
     * @param <E>   object type
     * @return single result queried
     */
    protected <E> E getSingleResult(TypedQuery<E> q, Class<E> clazz) {
        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
