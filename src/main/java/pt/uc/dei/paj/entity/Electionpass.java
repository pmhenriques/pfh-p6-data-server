package pt.uc.dei.paj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Electionpass.
 */
@Entity
@Table(name="electionpass")
public class Electionpass implements Serializable {

    private static final long serialVersionUID = 2185267011210114591L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long electionPassId;

    @NotNull
    @Column(name = "election_id", length =100, nullable = false)
    private long electionId;

    @NotNull
    @Column(name = "voter_id", nullable = false)
    private long voterId;

    @NotNull
    @Column(name = "voted", nullable = false)
    private boolean voted;

    @Column(name = "password" ,length = 100)
    private String password;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "fk_voter", updatable = false, nullable = false)
    private Voter voter;*/

    public Electionpass() {
    }

    public long getElectionPassId() {
        return electionPassId;
    }

    public void setElectionPassId(long electionPassId) {
        this.electionPassId = electionPassId;
    }

    public long getElectionId() {
        return electionId;
    }

    public void setElectionId(long electionId) {
        this.electionId = electionId;
    }

    public long getVoterId() {
        return voterId;
    }

    public void setVoterId(long voterId) {
        this.voterId = voterId;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }*/
}
