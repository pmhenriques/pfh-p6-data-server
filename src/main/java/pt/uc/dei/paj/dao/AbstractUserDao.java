package pt.uc.dei.paj.dao;

import com.google.common.hash.Hashing;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;


/**
 * This class accesses data of Admin and Voter entities (users).
 *
 * @param <T> type of class, in this case Customer, Driver or Restaurant.
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public abstract class AbstractUserDao<T extends Serializable> extends AbstractDao<T> {

    private static final long serialVersionUID = -7630677551028811659L;

    public AbstractUserDao(Class<T> clazz) {
        super(clazz);
    }

    /**
     * Queries a user with a given a username.
     *
     * @param username username
     * @return queried user
     */
    public T findUsername(String username) {
        TypedQuery<T> q = getEntityManager().createNamedQuery("findByUsername", getClazz());
        q.setParameter("username", username);
        return getSingleResult(q);
    }

    /**
     * Queries a voter with a given a civil id number.
     *
     * @param civilIDnumber civilIDnumber
     * @return queried voter
     */
    public T findByIDnumber(String civilIDnumber) {
        TypedQuery<T> q = getEntityManager().createNamedQuery("findByIDnumber", getClazz());
        q.setParameter("civilID", civilIDnumber);
        return getSingleResult(q);
    }

    /**
     * Queries if given admin credentials are valid: username match with password.
     *
     * @param username username
     * @param password password
     * @return true if credentials are valid
     */

    public boolean isAdminCredentialsValid(String username, String password) {
        TypedQuery<Long> q = getEntityManager().createNamedQuery("isAdminCredentialsValid", Long.class);
        q.setParameter("username", username);
        q.setParameter( "password", Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString());
        return q.getSingleResult() == 1L;
    }
}