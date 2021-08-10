/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author terry
 */
@Data
@Embeddable
public class SegUsuarioAgenciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_usuario")
    private String codUsuario;
    @Basic(optional = false)
    @Column(name = "cod_agencia")
    private String codAgencia;
    
}
