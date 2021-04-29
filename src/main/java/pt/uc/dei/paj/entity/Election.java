package pt.uc.dei.paj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity implementation class for Entity: Election
 */
@Entity
@Table(name="elections")
public class Election implements Serializable {

    private final static long serialVersionUID = 2588025171560022939L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long electionId; //primary key

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.-]{2,}$")
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @NotNull
    @Column(name = "win_method", length = 100, nullable = false)
    private String winMethod;

    @NotNull
    @Column(name = "start_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "close_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime closeTime;

    /*@OneToMany(mappedBy = "votes", fetch = FetchType.LAZY)
    private List<Vote> votes; //bidirectional relationship*/



    public Election() {
    }

    public long getId() {
        return electionId;
    }

    public void setId(long id) {
        this.electionId = id;
    }

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
}
