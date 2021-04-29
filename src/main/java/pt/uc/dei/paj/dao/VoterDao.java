package pt.uc.dei.paj.dao;
import pt.uc.dei.paj.entity.*;
import pt.uc.dei.paj.exceptions.*;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class VoterDao extends AbstractUserDao<Voter> {

    private static final long serialVersionUID = 1025397803693639371L;

    public VoterDao() {
        super(Voter.class);
    }

    /**
     * Queries if given civil id number is valid
     * @param civilIdNum
     * @return true if number is valid
     */

    public boolean isCivilIdNumValid(String civilIdNum) {
        TypedQuery<Long> q = getEntityManager().createNamedQuery("findByIdNumber", Long.class);
        q.setParameter("civilIdNum", civilIdNum);
        return q.getSingleResult() == 1L;
    }

    /**
     * Adds a voter to the database
     * @param civil_id_num
     * @param name
     * @param cellphone
     * @return voter
     */
    public Voter add(String civilIDnum, String name, String cellPhone) {

        if (findByIDnumber(civilIDnum) != null) {
            throw new DuplicatedEntityException("Voter with civil id number " + civilIDnum + " already exists!");
        }

        Voter voter = new Voter();
        voter.setCivilIdNum(civilIDnum);
        voter.setName(name);
        voter.setCellPhone(cellPhone);

        persist(voter);

        return voter;
    }
}
