package pt.uc.dei.paj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="votes")
public class Vote implements Serializable{

    private final static long serialVersionUID = -5197393351429771713L;

    @Id
    @Column(name = "election_id", length =100, nullable = false)
    private long electionId;

    @NotNull
    @Column(name="candidate_id", length=100, nullable = false)
    private long candidateId;

    @NotNull
    @Column(name="token", length = 100, nullable = false)
    private String token;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_election", foreignKey = @ForeignKey(name = "vote_election_fk"))
    private Election election;*/

    public Vote() {
    }

    public long getElectionId() {
        return electionId;
    }

    public void setElectionId(long electionId) {
        this.electionId = electionId;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

   /* public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }*/
}

