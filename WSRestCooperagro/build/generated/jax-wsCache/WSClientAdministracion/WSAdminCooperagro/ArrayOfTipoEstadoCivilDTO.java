
package WSAdminCooperagro;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for ArrayOfTipoEstadoCivilDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ArrayOfTipoEstadoCivilDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="TipoEstadoCivilDTO" type="{https://ebssas.com/}TipoEstadoCivilDTO" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTipoEstadoCivilDTO", propOrder = {
    "tipoEstadoCivilDTO"
})
public class ArrayOfTipoEstadoCivilDTO {

    @XmlElement(name = "TipoEstadoCivilDTO", nillable = true)
    protected List<TipoEstadoCivilDTO> tipoEstadoCivilDTO;

    /**
     * Gets the value of the tipoEstadoCivilDTO property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the tipoEstadoCivilDTO property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTipoEstadoCivilDTO().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TipoEstadoCivilDTO }
     * 
     * 
     */
    public List<TipoEstadoCivilDTO> getTipoEstadoCivilDTO() {
        if (tipoEstadoCivilDTO == null) {
            tipoEstadoCivilDTO = new ArrayList<TipoEstadoCivilDTO>();
        }
        return this.tipoEstadoCivilDTO;
    }

}
