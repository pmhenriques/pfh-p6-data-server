package pt.uc.dei.paj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Candidate
 */
@Entity
@Table(name="candidates")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 6844698196731188523L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key

    @NotNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(name = "icon_file_path", length = 100, nullable = false)
    private String iconFilePath;

    public Candidate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconFilePath() {
        return iconFilePath;
    }

    public void setIconFilePath(String iconFilePath) {
        this.iconFilePath = iconFilePath;
    }
}
