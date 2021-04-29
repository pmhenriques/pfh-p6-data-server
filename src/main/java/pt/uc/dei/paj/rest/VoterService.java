package pt.uc.dei.paj.rest;

import pt.uc.dei.paj.dao.VoterDao;
import pt.uc.dei.paj.entity.Voter;
import pt.uc.dei.paj.rest.controllers.requests.VoterRegisterRequest;
import pt.uc.dei.paj.rest.controllers.responses.VoterResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**This class manages entity: Voter
 * Service creates a response.
 * Voter service depends on {@link VoterDao} data access object
 */

@ApplicationScoped
public class VoterService {

    @Inject
    private VoterDao voterDao;

    /**
     * Creates a response to the request: create a new Voter
     * @param voterRegisterRequest request
     * @return response
     */

    public VoterResponse create(VoterRegisterRequest voterRegisterRequest) {
        Voter voter = voterDao.add(
                voterRegisterRequest.getCivilIDnum(),
                voterRegisterRequest.getName(),
                voterRegisterRequest.getCellPhone());

        VoterResponse voterResponse =  new VoterResponse();
        voterResponse.setCivilIDnum(voter.getCivilIdNum());
        voterResponse.setName(voter.getName());
        voterResponse.setCellPhone(voter.getCellPhone());

        return voterResponse;
    }
}
