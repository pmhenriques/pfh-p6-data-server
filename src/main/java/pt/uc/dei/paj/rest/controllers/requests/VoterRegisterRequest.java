package pt.uc.dei.paj.rest.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the request: register a new Voter.
 * This class is the data transfer object.
 * Request to be sent as Json object.
 */
@XmlRootElement
public class VoterRegisterRequest {

    /**
     * Voter Civil ID Number
     */
    @NotBlank
    @Pattern(regexp = "\\d{9}[\\w\\d]{2}|\\d{8}-\\d[\\d\\w]{2}\\d")
    private String civilIDnum;

    /**
     * Voter name
     */
    @NotBlank
    private String name;

    @NotBlank
    private String cellPhone;

    public String getCivilIDnum() {
        return civilIDnum;
    }

    public void setCivilIDnum(String civilIDnum) {
        this.civilIDnum = civilIDnum;
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
