
package com.ebssas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for personasDTO complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="personasDTO"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="I_Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Tipo_Person" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Iden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ciudad_Exp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Codigo_Asoc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fecha_Exp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Retencion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="N_Distrib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Forma_Pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Dia_Pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Vinculac_Lab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_E_Mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Clave_Int" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Ingreso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Ing_Emp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Oficina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Sistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Acto_Ad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Act_Ec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Asesor_Com" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Numveccod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Numactadm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Estado_Act" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Apellidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Nombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Nacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ciudad_Nac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Estado_Civil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="N_Salario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Nivel_Estudio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Profesion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Cargo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Dependencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Pagaduria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Num_Per_Car" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Residente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ciudad_Res" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fecha_Resid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Aficion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Cont" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Tratamiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Razon_Soc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Sigla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Icn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Acto_Creac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ciudad_Cre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Sector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Tipo_Sociedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Objeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Acto_Ad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Acto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Sector_Pub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Nro_Empleados" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Registro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Sueldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="F_Fec_Fundacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Vigencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Fondo_Emp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Cod_Emp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Pais_Nac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Pais_Seg_Nac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Num_Hijos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Frec_Pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Salario_Liquido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Salario_Embar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Otros_Ing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Desc_Otros_Ing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Proposito_Afi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Ori_Fon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Prom_Transac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_Tipo_Nomb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="D_Salario_Neto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Apellido_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="C_Apellido_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Tipo_cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Pagaduria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="MujerFam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="I_operf_ext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="B_resultado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="C_mjs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personasDTO", propOrder = {
    "iCodigo",
    "cTipoPerson",
    "cIdentificacion",
    "iTipoIden",
    "iCiudadExp",
    "cCodigoAsoc",
    "iTipoCliente",
    "fFechaExp",
    "cRetencion",
    "nDistrib",
    "cFormaPago",
    "iDiaPago",
    "iVinculacLab",
    "cDireccion",
    "cTelefono",
    "ceMail",
    "cClave",
    "cClaveInt",
    "fFecIngreso",
    "fFecIngEmp",
    "iOficina",
    "fFecSistema",
    "iActoAd",
    "iTipoActEc",
    "cAsesorCom",
    "iNumveccod",
    "cNumactadm",
    "cEstadoAct",
    "cApellidos",
    "cNombres",
    "cSexo",
    "fFecNacimiento",
    "iCiudadNac",
    "cEstadoCivil",
    "nSalario",
    "iNivelEstudio",
    "iProfesion",
    "iCargo",
    "iDependencia",
    "iPagaduria",
    "iNumPerCar",
    "cResidente",
    "iCiudadRes",
    "fFechaResid",
    "cAficion",
    "iTipoCont",
    "cTratamiento",
    "cNickname",
    "cRazonSoc",
    "cSigla",
    "cIcn",
    "cActoCreac",
    "iCiudadCre",
    "iSector",
    "cTipoSociedad",
    "cObjeto",
    "cActoAd",
    "fFecActo",
    "cSectorPub",
    "iNroEmpleados",
    "fFecRegistro",
    "iTipoSueldo",
    "fFecFundacion",
    "cVigencia",
    "cFondoEmp",
    "iCodEmp",
    "iPaisNac",
    "iPaisSegNac",
    "iNumHijos",
    "iFrecPago",
    "iSalarioLiquido",
    "iSalarioEmbar",
    "iOtrosIng",
    "cDescOtrosIng",
    "iPropositoAfi",
    "iOriFon",
    "iPromTransac",
    "iTipoNomb",
    "dSalarioNeto",
    "cApellido1",
    "cApellido2",
    "tipoCliente",
    "pagaduria",
    "mujerFam",
    "iOperfExt",
    "bResultado",
    "cMjs"
})
public class PersonasDTO {

    @XmlElement(name = "I_Codigo")
    protected String iCodigo;
    @XmlElement(name = "C_Tipo_Person")
    protected String cTipoPerson;
    @XmlElement(name = "C_Identificacion")
    protected String cIdentificacion;
    @XmlElement(name = "I_Tipo_Iden")
    protected String iTipoIden;
    @XmlElement(name = "I_Ciudad_Exp")
    protected String iCiudadExp;
    @XmlElement(name = "C_Codigo_Asoc")
    protected String cCodigoAsoc;
    @XmlElement(name = "I_Tipo_Cliente")
    protected String iTipoCliente;
    @XmlElement(name = "F_Fecha_Exp")
    protected String fFechaExp;
    @XmlElement(name = "C_Retencion")
    protected String cRetencion;
    @XmlElement(name = "N_Distrib")
    protected String nDistrib;
    @XmlElement(name = "C_Forma_Pago")
    protected String cFormaPago;
    @XmlElement(name = "I_Dia_Pago")
    protected String iDiaPago;
    @XmlElement(name = "I_Vinculac_Lab")
    protected String iVinculacLab;
    @XmlElement(name = "C_Direccion")
    protected String cDireccion;
    @XmlElement(name = "C_Telefono")
    protected String cTelefono;
    @XmlElement(name = "C_E_Mail")
    protected String ceMail;
    @XmlElement(name = "C_Clave")
    protected String cClave;
    @XmlElement(name = "C_Clave_Int")
    protected String cClaveInt;
    @XmlElement(name = "F_Fec_Ingreso")
    protected String fFecIngreso;
    @XmlElement(name = "F_Fec_Ing_Emp")
    protected String fFecIngEmp;
    @XmlElement(name = "I_Oficina")
    protected String iOficina;
    @XmlElement(name = "F_Fec_Sistema")
    protected String fFecSistema;
    @XmlElement(name = "I_Acto_Ad")
    protected String iActoAd;
    @XmlElement(name = "I_Tipo_Act_Ec")
    protected String iTipoActEc;
    @XmlElement(name = "C_Asesor_Com")
    protected String cAsesorCom;
    @XmlElement(name = "I_Numveccod")
    protected String iNumveccod;
    @XmlElement(name = "C_Numactadm")
    protected String cNumactadm;
    @XmlElement(name = "C_Estado_Act")
    protected String cEstadoAct;
    @XmlElement(name = "C_Apellidos")
    protected String cApellidos;
    @XmlElement(name = "C_Nombres")
    protected String cNombres;
    @XmlElement(name = "C_Sexo")
    protected String cSexo;
    @XmlElement(name = "F_Fec_Nacimiento")
    protected String fFecNacimiento;
    @XmlElement(name = "I_Ciudad_Nac")
    protected String iCiudadNac;
    @XmlElement(name = "C_Estado_Civil")
    protected String cEstadoCivil;
    @XmlElement(name = "N_Salario")
    protected String nSalario;
    @XmlElement(name = "I_Nivel_Estudio")
    protected String iNivelEstudio;
    @XmlElement(name = "I_Profesion")
    protected String iProfesion;
    @XmlElement(name = "I_Cargo")
    protected String iCargo;
    @XmlElement(name = "I_Dependencia")
    protected String iDependencia;
    @XmlElement(name = "I_Pagaduria")
    protected String iPagaduria;
    @XmlElement(name = "I_Num_Per_Car")
    protected String iNumPerCar;
    @XmlElement(name = "C_Residente")
    protected String cResidente;
    @XmlElement(name = "I_Ciudad_Res")
    protected String iCiudadRes;
    @XmlElement(name = "F_Fecha_Resid")
    protected String fFechaResid;
    @XmlElement(name = "C_Aficion")
    protected String cAficion;
    @XmlElement(name = "I_Tipo_Cont")
    protected String iTipoCont;
    @XmlElement(name = "C_Tratamiento")
    protected String cTratamiento;
    @XmlElement(name = "C_Nickname")
    protected String cNickname;
    @XmlElement(name = "C_Razon_Soc")
    protected String cRazonSoc;
    @XmlElement(name = "C_Sigla")
    protected String cSigla;
    @XmlElement(name = "C_Icn")
    protected String cIcn;
    @XmlElement(name = "C_Acto_Creac")
    protected String cActoCreac;
    @XmlElement(name = "I_Ciudad_Cre")
    protected String iCiudadCre;
    @XmlElement(name = "I_Sector")
    protected String iSector;
    @XmlElement(name = "C_Tipo_Sociedad")
    protected String cTipoSociedad;
    @XmlElement(name = "C_Objeto")
    protected String cObjeto;
    @XmlElement(name = "C_Acto_Ad")
    protected String cActoAd;
    @XmlElement(name = "F_Fec_Acto")
    protected String fFecActo;
    @XmlElement(name = "C_Sector_Pub")
    protected String cSectorPub;
    @XmlElement(name = "I_Nro_Empleados")
    protected String iNroEmpleados;
    @XmlElement(name = "F_Fec_Registro")
    protected String fFecRegistro;
    @XmlElement(name = "I_Tipo_Sueldo")
    protected String iTipoSueldo;
    @XmlElement(name = "F_Fec_Fundacion")
    protected String fFecFundacion;
    @XmlElement(name = "C_Vigencia")
    protected String cVigencia;
    @XmlElement(name = "C_Fondo_Emp")
    protected String cFondoEmp;
    @XmlElement(name = "I_Cod_Emp")
    protected String iCodEmp;
    @XmlElement(name = "I_Pais_Nac")
    protected String iPaisNac;
    @XmlElement(name = "I_Pais_Seg_Nac")
    protected String iPaisSegNac;
    @XmlElement(name = "I_Num_Hijos")
    protected String iNumHijos;
    @XmlElement(name = "I_Frec_Pago")
    protected String iFrecPago;
    @XmlElement(name = "I_Salario_Liquido")
    protected String iSalarioLiquido;
    @XmlElement(name = "I_Salario_Embar")
    protected String iSalarioEmbar;
    @XmlElement(name = "I_Otros_Ing")
    protected String iOtrosIng;
    @XmlElement(name = "C_Desc_Otros_Ing")
    protected String cDescOtrosIng;
    @XmlElement(name = "I_Proposito_Afi")
    protected String iPropositoAfi;
    @XmlElement(name = "I_Ori_Fon")
    protected String iOriFon;
    @XmlElement(name = "I_Prom_Transac")
    protected String iPromTransac;
    @XmlElement(name = "I_Tipo_Nomb")
    protected String iTipoNomb;
    @XmlElement(name = "D_Salario_Neto")
    protected String dSalarioNeto;
    @XmlElement(name = "C_Apellido_1")
    protected String cApellido1;
    @XmlElement(name = "C_Apellido_2")
    protected String cApellido2;
    @XmlElement(name = "Tipo_cliente")
    protected String tipoCliente;
    @XmlElement(name = "Pagaduria")
    protected String pagaduria;
    @XmlElement(name = "MujerFam")
    protected String mujerFam;
    @XmlElement(name = "I_operf_ext")
    protected String iOperfExt;
    @XmlElement(name = "B_resultado")
    protected boolean bResultado;
    @XmlElement(name = "C_mjs")
    protected String cMjs;

    /**
     * Gets the value of the iCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICodigo() {
        return iCodigo;
    }

    /**
     * Sets the value of the iCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICodigo(String value) {
        this.iCodigo = value;
    }

    /**
     * Gets the value of the cTipoPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTipoPerson() {
        return cTipoPerson;
    }

    /**
     * Sets the value of the cTipoPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTipoPerson(String value) {
        this.cTipoPerson = value;
    }

    /**
     * Gets the value of the cIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIdentificacion() {
        return cIdentificacion;
    }

    /**
     * Sets the value of the cIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIdentificacion(String value) {
        this.cIdentificacion = value;
    }

    /**
     * Gets the value of the iTipoIden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoIden() {
        return iTipoIden;
    }

    /**
     * Sets the value of the iTipoIden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoIden(String value) {
        this.iTipoIden = value;
    }

    /**
     * Gets the value of the iCiudadExp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICiudadExp() {
        return iCiudadExp;
    }

    /**
     * Sets the value of the iCiudadExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICiudadExp(String value) {
        this.iCiudadExp = value;
    }

    /**
     * Gets the value of the cCodigoAsoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCodigoAsoc() {
        return cCodigoAsoc;
    }

    /**
     * Sets the value of the cCodigoAsoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCodigoAsoc(String value) {
        this.cCodigoAsoc = value;
    }

    /**
     * Gets the value of the iTipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoCliente() {
        return iTipoCliente;
    }

    /**
     * Sets the value of the iTipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoCliente(String value) {
        this.iTipoCliente = value;
    }

    /**
     * Gets the value of the fFechaExp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFechaExp() {
        return fFechaExp;
    }

    /**
     * Sets the value of the fFechaExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFechaExp(String value) {
        this.fFechaExp = value;
    }

    /**
     * Gets the value of the cRetencion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRetencion() {
        return cRetencion;
    }

    /**
     * Sets the value of the cRetencion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRetencion(String value) {
        this.cRetencion = value;
    }

    /**
     * Gets the value of the nDistrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNDistrib() {
        return nDistrib;
    }

    /**
     * Sets the value of the nDistrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNDistrib(String value) {
        this.nDistrib = value;
    }

    /**
     * Gets the value of the cFormaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFormaPago() {
        return cFormaPago;
    }

    /**
     * Sets the value of the cFormaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFormaPago(String value) {
        this.cFormaPago = value;
    }

    /**
     * Gets the value of the iDiaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDiaPago() {
        return iDiaPago;
    }

    /**
     * Sets the value of the iDiaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDiaPago(String value) {
        this.iDiaPago = value;
    }

    /**
     * Gets the value of the iVinculacLab property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVinculacLab() {
        return iVinculacLab;
    }

    /**
     * Sets the value of the iVinculacLab property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVinculacLab(String value) {
        this.iVinculacLab = value;
    }

    /**
     * Gets the value of the cDireccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDireccion() {
        return cDireccion;
    }

    /**
     * Sets the value of the cDireccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDireccion(String value) {
        this.cDireccion = value;
    }

    /**
     * Gets the value of the cTelefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTelefono() {
        return cTelefono;
    }

    /**
     * Sets the value of the cTelefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTelefono(String value) {
        this.cTelefono = value;
    }

    /**
     * Gets the value of the ceMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEMail() {
        return ceMail;
    }

    /**
     * Sets the value of the ceMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEMail(String value) {
        this.ceMail = value;
    }

    /**
     * Gets the value of the cClave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCClave() {
        return cClave;
    }

    /**
     * Sets the value of the cClave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCClave(String value) {
        this.cClave = value;
    }

    /**
     * Gets the value of the cClaveInt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCClaveInt() {
        return cClaveInt;
    }

    /**
     * Sets the value of the cClaveInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCClaveInt(String value) {
        this.cClaveInt = value;
    }

    /**
     * Gets the value of the fFecIngreso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecIngreso() {
        return fFecIngreso;
    }

    /**
     * Sets the value of the fFecIngreso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecIngreso(String value) {
        this.fFecIngreso = value;
    }

    /**
     * Gets the value of the fFecIngEmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecIngEmp() {
        return fFecIngEmp;
    }

    /**
     * Sets the value of the fFecIngEmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecIngEmp(String value) {
        this.fFecIngEmp = value;
    }

    /**
     * Gets the value of the iOficina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIOficina() {
        return iOficina;
    }

    /**
     * Sets the value of the iOficina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIOficina(String value) {
        this.iOficina = value;
    }

    /**
     * Gets the value of the fFecSistema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecSistema() {
        return fFecSistema;
    }

    /**
     * Sets the value of the fFecSistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecSistema(String value) {
        this.fFecSistema = value;
    }

    /**
     * Gets the value of the iActoAd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIActoAd() {
        return iActoAd;
    }

    /**
     * Sets the value of the iActoAd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIActoAd(String value) {
        this.iActoAd = value;
    }

    /**
     * Gets the value of the iTipoActEc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoActEc() {
        return iTipoActEc;
    }

    /**
     * Sets the value of the iTipoActEc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoActEc(String value) {
        this.iTipoActEc = value;
    }

    /**
     * Gets the value of the cAsesorCom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAsesorCom() {
        return cAsesorCom;
    }

    /**
     * Sets the value of the cAsesorCom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAsesorCom(String value) {
        this.cAsesorCom = value;
    }

    /**
     * Gets the value of the iNumveccod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINumveccod() {
        return iNumveccod;
    }

    /**
     * Sets the value of the iNumveccod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINumveccod(String value) {
        this.iNumveccod = value;
    }

    /**
     * Gets the value of the cNumactadm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNumactadm() {
        return cNumactadm;
    }

    /**
     * Sets the value of the cNumactadm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNumactadm(String value) {
        this.cNumactadm = value;
    }

    /**
     * Gets the value of the cEstadoAct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEstadoAct() {
        return cEstadoAct;
    }

    /**
     * Sets the value of the cEstadoAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEstadoAct(String value) {
        this.cEstadoAct = value;
    }

    /**
     * Gets the value of the cApellidos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCApellidos() {
        return cApellidos;
    }

    /**
     * Sets the value of the cApellidos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCApellidos(String value) {
        this.cApellidos = value;
    }

    /**
     * Gets the value of the cNombres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNombres() {
        return cNombres;
    }

    /**
     * Sets the value of the cNombres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNombres(String value) {
        this.cNombres = value;
    }

    /**
     * Gets the value of the cSexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSexo() {
        return cSexo;
    }

    /**
     * Sets the value of the cSexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSexo(String value) {
        this.cSexo = value;
    }

    /**
     * Gets the value of the fFecNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecNacimiento() {
        return fFecNacimiento;
    }

    /**
     * Sets the value of the fFecNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecNacimiento(String value) {
        this.fFecNacimiento = value;
    }

    /**
     * Gets the value of the iCiudadNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICiudadNac() {
        return iCiudadNac;
    }

    /**
     * Sets the value of the iCiudadNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICiudadNac(String value) {
        this.iCiudadNac = value;
    }

    /**
     * Gets the value of the cEstadoCivil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCEstadoCivil() {
        return cEstadoCivil;
    }

    /**
     * Sets the value of the cEstadoCivil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCEstadoCivil(String value) {
        this.cEstadoCivil = value;
    }

    /**
     * Gets the value of the nSalario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSalario() {
        return nSalario;
    }

    /**
     * Sets the value of the nSalario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSalario(String value) {
        this.nSalario = value;
    }

    /**
     * Gets the value of the iNivelEstudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINivelEstudio() {
        return iNivelEstudio;
    }

    /**
     * Sets the value of the iNivelEstudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINivelEstudio(String value) {
        this.iNivelEstudio = value;
    }

    /**
     * Gets the value of the iProfesion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIProfesion() {
        return iProfesion;
    }

    /**
     * Sets the value of the iProfesion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIProfesion(String value) {
        this.iProfesion = value;
    }

    /**
     * Gets the value of the iCargo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICargo() {
        return iCargo;
    }

    /**
     * Sets the value of the iCargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICargo(String value) {
        this.iCargo = value;
    }

    /**
     * Gets the value of the iDependencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDependencia() {
        return iDependencia;
    }

    /**
     * Sets the value of the iDependencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDependencia(String value) {
        this.iDependencia = value;
    }

    /**
     * Gets the value of the iPagaduria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPagaduria() {
        return iPagaduria;
    }

    /**
     * Sets the value of the iPagaduria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPagaduria(String value) {
        this.iPagaduria = value;
    }

    /**
     * Gets the value of the iNumPerCar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINumPerCar() {
        return iNumPerCar;
    }

    /**
     * Sets the value of the iNumPerCar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINumPerCar(String value) {
        this.iNumPerCar = value;
    }

    /**
     * Gets the value of the cResidente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCResidente() {
        return cResidente;
    }

    /**
     * Sets the value of the cResidente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCResidente(String value) {
        this.cResidente = value;
    }

    /**
     * Gets the value of the iCiudadRes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICiudadRes() {
        return iCiudadRes;
    }

    /**
     * Sets the value of the iCiudadRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICiudadRes(String value) {
        this.iCiudadRes = value;
    }

    /**
     * Gets the value of the fFechaResid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFechaResid() {
        return fFechaResid;
    }

    /**
     * Sets the value of the fFechaResid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFechaResid(String value) {
        this.fFechaResid = value;
    }

    /**
     * Gets the value of the cAficion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAficion() {
        return cAficion;
    }

    /**
     * Sets the value of the cAficion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAficion(String value) {
        this.cAficion = value;
    }

    /**
     * Gets the value of the iTipoCont property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoCont() {
        return iTipoCont;
    }

    /**
     * Sets the value of the iTipoCont property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoCont(String value) {
        this.iTipoCont = value;
    }

    /**
     * Gets the value of the cTratamiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTratamiento() {
        return cTratamiento;
    }

    /**
     * Sets the value of the cTratamiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTratamiento(String value) {
        this.cTratamiento = value;
    }

    /**
     * Gets the value of the cNickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNickname() {
        return cNickname;
    }

    /**
     * Sets the value of the cNickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNickname(String value) {
        this.cNickname = value;
    }

    /**
     * Gets the value of the cRazonSoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRazonSoc() {
        return cRazonSoc;
    }

    /**
     * Sets the value of the cRazonSoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRazonSoc(String value) {
        this.cRazonSoc = value;
    }

    /**
     * Gets the value of the cSigla property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSigla() {
        return cSigla;
    }

    /**
     * Sets the value of the cSigla property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSigla(String value) {
        this.cSigla = value;
    }

    /**
     * Gets the value of the cIcn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIcn() {
        return cIcn;
    }

    /**
     * Sets the value of the cIcn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIcn(String value) {
        this.cIcn = value;
    }

    /**
     * Gets the value of the cActoCreac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCActoCreac() {
        return cActoCreac;
    }

    /**
     * Sets the value of the cActoCreac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCActoCreac(String value) {
        this.cActoCreac = value;
    }

    /**
     * Gets the value of the iCiudadCre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICiudadCre() {
        return iCiudadCre;
    }

    /**
     * Sets the value of the iCiudadCre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICiudadCre(String value) {
        this.iCiudadCre = value;
    }

    /**
     * Gets the value of the iSector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISector() {
        return iSector;
    }

    /**
     * Sets the value of the iSector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISector(String value) {
        this.iSector = value;
    }

    /**
     * Gets the value of the cTipoSociedad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTipoSociedad() {
        return cTipoSociedad;
    }

    /**
     * Sets the value of the cTipoSociedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTipoSociedad(String value) {
        this.cTipoSociedad = value;
    }

    /**
     * Gets the value of the cObjeto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCObjeto() {
        return cObjeto;
    }

    /**
     * Sets the value of the cObjeto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCObjeto(String value) {
        this.cObjeto = value;
    }

    /**
     * Gets the value of the cActoAd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCActoAd() {
        return cActoAd;
    }

    /**
     * Sets the value of the cActoAd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCActoAd(String value) {
        this.cActoAd = value;
    }

    /**
     * Gets the value of the fFecActo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecActo() {
        return fFecActo;
    }

    /**
     * Sets the value of the fFecActo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecActo(String value) {
        this.fFecActo = value;
    }

    /**
     * Gets the value of the cSectorPub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSectorPub() {
        return cSectorPub;
    }

    /**
     * Sets the value of the cSectorPub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSectorPub(String value) {
        this.cSectorPub = value;
    }

    /**
     * Gets the value of the iNroEmpleados property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINroEmpleados() {
        return iNroEmpleados;
    }

    /**
     * Sets the value of the iNroEmpleados property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINroEmpleados(String value) {
        this.iNroEmpleados = value;
    }

    /**
     * Gets the value of the fFecRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecRegistro() {
        return fFecRegistro;
    }

    /**
     * Sets the value of the fFecRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecRegistro(String value) {
        this.fFecRegistro = value;
    }

    /**
     * Gets the value of the iTipoSueldo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoSueldo() {
        return iTipoSueldo;
    }

    /**
     * Sets the value of the iTipoSueldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoSueldo(String value) {
        this.iTipoSueldo = value;
    }

    /**
     * Gets the value of the fFecFundacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFFecFundacion() {
        return fFecFundacion;
    }

    /**
     * Sets the value of the fFecFundacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFFecFundacion(String value) {
        this.fFecFundacion = value;
    }

    /**
     * Gets the value of the cVigencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVigencia() {
        return cVigencia;
    }

    /**
     * Sets the value of the cVigencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVigencia(String value) {
        this.cVigencia = value;
    }

    /**
     * Gets the value of the cFondoEmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFondoEmp() {
        return cFondoEmp;
    }

    /**
     * Sets the value of the cFondoEmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFondoEmp(String value) {
        this.cFondoEmp = value;
    }

    /**
     * Gets the value of the iCodEmp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICodEmp() {
        return iCodEmp;
    }

    /**
     * Sets the value of the iCodEmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICodEmp(String value) {
        this.iCodEmp = value;
    }

    /**
     * Gets the value of the iPaisNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPaisNac() {
        return iPaisNac;
    }

    /**
     * Sets the value of the iPaisNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPaisNac(String value) {
        this.iPaisNac = value;
    }

    /**
     * Gets the value of the iPaisSegNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPaisSegNac() {
        return iPaisSegNac;
    }

    /**
     * Sets the value of the iPaisSegNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPaisSegNac(String value) {
        this.iPaisSegNac = value;
    }

    /**
     * Gets the value of the iNumHijos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINumHijos() {
        return iNumHijos;
    }

    /**
     * Sets the value of the iNumHijos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINumHijos(String value) {
        this.iNumHijos = value;
    }

    /**
     * Gets the value of the iFrecPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFrecPago() {
        return iFrecPago;
    }

    /**
     * Sets the value of the iFrecPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFrecPago(String value) {
        this.iFrecPago = value;
    }

    /**
     * Gets the value of the iSalarioLiquido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISalarioLiquido() {
        return iSalarioLiquido;
    }

    /**
     * Sets the value of the iSalarioLiquido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISalarioLiquido(String value) {
        this.iSalarioLiquido = value;
    }

    /**
     * Gets the value of the iSalarioEmbar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISalarioEmbar() {
        return iSalarioEmbar;
    }

    /**
     * Sets the value of the iSalarioEmbar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISalarioEmbar(String value) {
        this.iSalarioEmbar = value;
    }

    /**
     * Gets the value of the iOtrosIng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIOtrosIng() {
        return iOtrosIng;
    }

    /**
     * Sets the value of the iOtrosIng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIOtrosIng(String value) {
        this.iOtrosIng = value;
    }

    /**
     * Gets the value of the cDescOtrosIng property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDescOtrosIng() {
        return cDescOtrosIng;
    }

    /**
     * Sets the value of the cDescOtrosIng property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDescOtrosIng(String value) {
        this.cDescOtrosIng = value;
    }

    /**
     * Gets the value of the iPropositoAfi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPropositoAfi() {
        return iPropositoAfi;
    }

    /**
     * Sets the value of the iPropositoAfi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPropositoAfi(String value) {
        this.iPropositoAfi = value;
    }

    /**
     * Gets the value of the iOriFon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIOriFon() {
        return iOriFon;
    }

    /**
     * Sets the value of the iOriFon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIOriFon(String value) {
        this.iOriFon = value;
    }

    /**
     * Gets the value of the iPromTransac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPromTransac() {
        return iPromTransac;
    }

    /**
     * Sets the value of the iPromTransac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPromTransac(String value) {
        this.iPromTransac = value;
    }

    /**
     * Gets the value of the iTipoNomb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITipoNomb() {
        return iTipoNomb;
    }

    /**
     * Sets the value of the iTipoNomb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITipoNomb(String value) {
        this.iTipoNomb = value;
    }

    /**
     * Gets the value of the dSalarioNeto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSalarioNeto() {
        return dSalarioNeto;
    }

    /**
     * Sets the value of the dSalarioNeto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSalarioNeto(String value) {
        this.dSalarioNeto = value;
    }

    /**
     * Gets the value of the cApellido1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCApellido1() {
        return cApellido1;
    }

    /**
     * Sets the value of the cApellido1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCApellido1(String value) {
        this.cApellido1 = value;
    }

    /**
     * Gets the value of the cApellido2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCApellido2() {
        return cApellido2;
    }

    /**
     * Sets the value of the cApellido2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCApellido2(String value) {
        this.cApellido2 = value;
    }

    /**
     * Gets the value of the tipoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Sets the value of the tipoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCliente(String value) {
        this.tipoCliente = value;
    }

    /**
     * Gets the value of the pagaduria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagaduria() {
        return pagaduria;
    }

    /**
     * Sets the value of the pagaduria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagaduria(String value) {
        this.pagaduria = value;
    }

    /**
     * Gets the value of the mujerFam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMujerFam() {
        return mujerFam;
    }

    /**
     * Sets the value of the mujerFam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMujerFam(String value) {
        this.mujerFam = value;
    }

    /**
     * Gets the value of the iOperfExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIOperfExt() {
        return iOperfExt;
    }

    /**
     * Sets the value of the iOperfExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIOperfExt(String value) {
        this.iOperfExt = value;
    }

    /**
     * Gets the value of the bResultado property.
     * 
     */
    public boolean isBResultado() {
        return bResultado;
    }

    /**
     * Sets the value of the bResultado property.
     * 
     */
    public void setBResultado(boolean value) {
        this.bResultado = value;
    }

    /**
     * Gets the value of the cMjs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCMjs() {
        return cMjs;
    }

    /**
     * Sets the value of the cMjs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCMjs(String value) {
        this.cMjs = value;
    }

}
