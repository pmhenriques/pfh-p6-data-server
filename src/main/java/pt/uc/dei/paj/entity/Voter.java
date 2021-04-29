package pt.uc.dei.paj.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name="voters")
@NamedQueries({
        @NamedQuery(name = "findByIdNumber", query = "SELECT v FROM Voter v WHERE v.civilIdNum = :civilIdNum")
})
public class Voter implements Serializable {

    private final static long serialVersionUID = 9200479517673829480L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key

    @NotNull
    @Pattern(regexp = "\\d{9}[\\w\\d]{2}|\\d{8}-\\d[\\d\\w]{2}\\d")
    @Column(name="civil_id_num", length=100, nullable = false, unique = true)
    private String civilIdNum;

    @NotNull
    @Column(name="name", length=100, nullable = false)
    private String name;

    @NotNull
    @Column(name="cellphone", length=100, nullable = false, unique = true)
    private String cellPhone;

    public Voter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCivilIdNum() {
        return civilIdNum;
    }

    public void setCivilIdNum(String civilIdNum) {
        this.civilIdNum = civilIdNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
