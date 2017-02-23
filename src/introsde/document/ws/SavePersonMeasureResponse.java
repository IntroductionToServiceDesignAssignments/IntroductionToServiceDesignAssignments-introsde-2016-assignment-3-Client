
package introsde.document.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for savePersonMeasureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="savePersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hpId" type="{http://ws.document.introsde/}healthProfile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonMeasureResponse", propOrder = {
    "hpId"
})
public class SavePersonMeasureResponse {

    protected HealthProfile hpId;

    /**
     * Gets the value of the hpId property.
     * 
     * @return
     *     possible object is
     *     {@link HealthProfile }
     *     
     */
    public HealthProfile getHpId() {
        return hpId;
    }

    /**
     * Sets the value of the hpId property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthProfile }
     *     
     */
    public void setHpId(HealthProfile value) {
        this.hpId = value;
    }

}
