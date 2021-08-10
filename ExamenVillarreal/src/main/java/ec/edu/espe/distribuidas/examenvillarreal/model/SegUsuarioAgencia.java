/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author terry
 */
@Data
@Entity
@Table(name = "seg_usuario_agencia", schema = "public", catalog = "examen")

public class SegUsuarioAgencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegUsuarioAgenciaPK segUsuarioAgenciaPK;
    @Basic(optional = false)
    @Column(name = "por_omision")
    private String porOmision;
    @JoinColumn(name = "cod_agencia", referencedColumnName = "cod_agencia", 
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GenAgencia genAgencia;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", 
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
  
}
