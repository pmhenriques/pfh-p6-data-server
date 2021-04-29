package pt.uc.dei.paj.entity;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Admin.
 */
@Entity
@Table(name="admins")
@NamedQueries({
        @NamedQuery(name = "isAdminCredentialsValid", query = "SELECT COUNT (a.id) FROM Admin a WHERE a.username = :username AND a.password = :password"),
        @NamedQuery(name = "findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username"),
        @NamedQuery(name = "AdminFindAll", query = "SELECT a FROM Admin a")
})

public class Admin implements Serializable {

    private static final long serialVersionUID = 737329956960478450L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.-]{3,}$")
    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username; //unique

    @NotNull
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    public Admin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
