package pt.uc.dei.paj.rest.controllers.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the server response to requests: list information about a specific Voter.
 * This class is the data transfer object.
 * Voter response to be returned as a Json object.
 */
@XmlRootElement
public class VoterResponse {
    /**
     * Voter civil id number
     */
    private String civilIDnum;

    /**
     * Voter name
     */
    private String name;

    /**
     * Voter cellphone number
     */
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
