package pt.uc.dei.paj.rest.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class represents the request: create a new election
 * This class is the data transfer object.
 * Election request to be sent as Json object.
 */
@XmlRootElement
public class CreateElectionRequest {

    /**
     * Election title
     */
    @NotBlank
    private String title;

    /**
     *List of candidates, must be not empty.
     */
    @NotEmpty
    private List<@NotNull CandidateRequest> candidates;

    /**
     * List of voters. must be not empty
     */
    @NotEmpty
    private List<@NotNull VoterRequest> voters;

    /**
     * Election win method
     */
    @NotBlank
    private String winMethod;

    /**
     * Election start time
     */
    @NotNull
    private LocalDateTime startTime;

    /**
     * Election close time
     */
    @NotNull
    private LocalDateTime closeTime;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWinMethod() {
        return winMethod;
    }

    public void setWinMethod(String winMethod) {
        this.winMethod = winMethod;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public List<CandidateRequest> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateRequest> candidates) {
        this.candidates = candidates;
    }

    public List<VoterRequest> getVoters() {
        return voters;
    }

    public void setVoters(List<VoterRequest> voters) {
        this.voters = voters;
    }
}
