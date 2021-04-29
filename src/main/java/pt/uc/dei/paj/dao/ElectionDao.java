package pt.uc.dei.paj.dao;

import pt.uc.dei.paj.entity.Election;
import pt.uc.dei.paj.exceptions.*;

import javax.ejb.Stateless;
import java.time.LocalDateTime;

/**
 * Election data access object accesses entity data and
 * persists data in the database using interface EntityManager.
 * This class is stateless.
 */
@Stateless
public class ElectionDao extends AbstractDao<Election> {

    private static final long serialVersionUID = 6301520048734531973L;

    public ElectionDao() {
        super(Election.class);
    }

    /**
     * Adds a new Election
     * Election title is unique
     * @param title
     * @param startTime
     * @param closeTime
     * @return election
     */

    /*public Election addElection(String title, LocalDateTime startTime, LocalDateTime closeTime) {

        if(findTitle(title) != null) {
            throw new DuplicatedEntityException();
        }
    }*/

}
