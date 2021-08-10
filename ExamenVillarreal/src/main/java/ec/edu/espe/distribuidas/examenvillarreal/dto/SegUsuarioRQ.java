/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author terry
 */
@Data
public class SegUsuarioRQ {
    
    private String codigoUsuario;

    private List<String> codigosPerfiles;
    
    private String porOmision;
    
}
