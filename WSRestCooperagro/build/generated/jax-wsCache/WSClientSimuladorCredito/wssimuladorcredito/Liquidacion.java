
package wssimuladorcredito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for Liquidacion complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="Liquidacion"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{WSSimuladorCredito}General"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="n_num_cuo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="f_fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_sal_ini" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_capital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_cap_tf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_int_tf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_total" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="n_sal_fin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Liquidacion", propOrder = {
    "nNumCuo",
    "fFecha",
    "nSalIni",
    "nCapital",
    "nInt1",
    "nInt2",
    "nInt3",
    "nInt4",
    "nInt5",
    "nInt6",
    "nInt7",
    "nInt8",
    "nInt9",
    "nInt10",
    "nCapTf",
    "nIntTf",
    "nTotal",
    "nSalFin"
})
public class Liquidacion
    extends General
{

    @XmlElement(name = "n_num_cuo")
    protected String nNumCuo;
    @XmlElement(name = "f_fecha")
    protected String fFecha;
    @XmlElement(name = "n_sal_ini")
    protected String nSalIni;
    @XmlElement(name = "n_capital")
    protected String nCapital;
    @XmlElement(name = "n_int_1")
    protected String nInt1;
    @XmlElement(name = "n_int_2")
    protected String nInt2;
    @XmlElement(name = "n_int_3")
    protected String nInt3;
    @XmlElement(name = "n_int_4")
    protected String nInt4;
    @XmlElement(name = "n_int_5")
    protected String nInt5;
    @XmlElement(name = "n_int_6")
    protected String nInt6;
    @XmlElement(name = "n_int_7")
    protected String nInt7;
    @XmlElement(name = "n_int_8")
    protected String nInt8;
    @XmlElement(name = "n_int_9")
    protected String nInt9;
    @XmlElement(name = "n_int_10")
    protected String nInt10;
    @XmlElement(name = "n_cap_tf")
    protected String nCapTf;
    @XmlElement(name = "n_int_tf")
    protected String nIntTf;
    @XmlElement(name = "n_total")
    protected String nTotal;
    @XmlElement(name = "n_sal_fin")
    protected String nSalFin;

    /**
     * Gets the value of the nNumCuo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNNumCuo() {
        return nNumCuo;
    }

    /**
     * Sets the value of the nNumCuo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNNumCuo(String value) {
        this.nNumCuo = value;
    }

    /**
     * Gets the value of the fFecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecha() {
        return fFecha;
    }

    /**
     * Sets the value of the fFecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecha(String value) {
        this.fFecha = value;
    }

    /**
     * Gets the value of the nSalIni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSalIni() {
        return nSalIni;
    }

    /**
     * Sets the value of the nSalIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSalIni(String value) {
        this.nSalIni = value;
    }

    /**
     * Gets the value of the nCapital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNCapital() {
        return nCapital;
    }

    /**
     * Sets the value of the nCapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNCapital(String value) {
        this.nCapital = value;
    }

    /**
     * Gets the value of the nInt1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt1() {
        return nInt1;
    }

    /**
     * Sets the value of the nInt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt1(String value) {
        this.nInt1 = value;
    }

    /**
     * Gets the value of the nInt2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt2() {
        return nInt2;
    }

    /**
     * Sets the value of the nInt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt2(String value) {
        this.nInt2 = value;
    }

    /**
     * Gets the value of the nInt3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt3() {
        return nInt3;
    }

    /**
     * Sets the value of the nInt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt3(String value) {
        this.nInt3 = value;
    }

    /**
     * Gets the value of the nInt4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt4() {
        return nInt4;
    }

    /**
     * Sets the value of the nInt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt4(String value) {
        this.nInt4 = value;
    }

    /**
     * Gets the value of the nInt5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt5() {
        return nInt5;
    }

    /**
     * Sets the value of the nInt5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt5(String value) {
        this.nInt5 = value;
    }

    /**
     * Gets the value of the nInt6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt6() {
        return nInt6;
    }

    /**
     * Sets the value of the nInt6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt6(String value) {
        this.nInt6 = value;
    }

    /**
     * Gets the value of the nInt7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt7() {
        return nInt7;
    }

    /**
     * Sets the value of the nInt7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt7(String value) {
        this.nInt7 = value;
    }

    /**
     * Gets the value of the nInt8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt8() {
        return nInt8;
    }

    /**
     * Sets the value of the nInt8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt8(String value) {
        this.nInt8 = value;
    }

    /**
     * Gets the value of the nInt9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt9() {
        return nInt9;
    }

    /**
     * Sets the value of the nInt9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt9(String value) {
        this.nInt9 = value;
    }

    /**
     * Gets the value of the nInt10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNInt10() {
        return nInt10;
    }

    /**
     * Sets the value of the nInt10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNInt10(String value) {
        this.nInt10 = value;
    }

    /**
     * Gets the value of the nCapTf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNCapTf() {
        return nCapTf;
    }

    /**
     * Sets the value of the nCapTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNCapTf(String value) {
        this.nCapTf = value;
    }

    /**
     * Gets the value of the nIntTf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIntTf() {
        return nIntTf;
    }

    /**
     * Sets the value of the nIntTf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIntTf(String value) {
        this.nIntTf = value;
    }

    /**
     * Gets the value of the nTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNTotal() {
        return nTotal;
    }

    /**
     * Sets the value of the nTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNTotal(String value) {
        this.nTotal = value;
    }

    /**
     * Gets the value of the nSalFin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSalFin() {
        return nSalFin;
    }

    /**
     * Sets the value of the nSalFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSalFin(String value) {
        this.nSalFin = value;
    }

}
