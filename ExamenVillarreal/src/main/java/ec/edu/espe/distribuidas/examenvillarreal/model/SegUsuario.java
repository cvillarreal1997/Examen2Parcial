/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author terry
 */
@Data
@Entity
@Table(name = "seg_usuario", schema = "public", catalog = "examen")

public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_usuario")
    private String codUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "nro_intentos_fallidos")
    private int nroIntentosFallidos;
    @Basic(optional = false)
    @Column(name = "fecha_ultima_sesion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaSesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private Collection<SegUsuarioAgencia> segUsuarioAgenciaCollection;

    
}
