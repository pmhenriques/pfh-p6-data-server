package pt.uc.dei.paj.dao;

import pt.uc.dei.paj.entity.Candidate;
import pt.uc.dei.paj.exceptions.*;
import javax.ejb.Stateless;
/**
 * Candidate data access object accesses entity data and
 * persists data in the database using interface EntityManager.
 * This class is stateless.
 */
@Stateless
public class CandidateDao extends AbstractDao<Candidate> {

    private static final long serialVersionUID = 8317478627664774303L;

    public CandidateDao() {
        super(Candidate.class);
    }

    /**
     * Adds a Candidate to the database
     * @param name
     * @param iconFilepath
     * @return candidate
     */
    public Candidate add(String name, String iconFilepath) {
        if(findAll() != null) {
            throw new DuplicatedEntityException("Candidate with name " + name + " already exists");
        }

        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate.setIconFilePath(iconFilepath);

        persist(candidate);

        return candidate;
    }
}
