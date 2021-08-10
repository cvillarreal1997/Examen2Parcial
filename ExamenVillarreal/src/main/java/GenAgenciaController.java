/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import ec.edu.espe.distribuidas.examenvillarreal.service.GenAgenciaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author terry
 */
@RequestMapping("/api/genagencia")
@RestController
public class GenAgenciaController {
     private final GenAgenciaService service;
      public GenAgenciaController(GenAgenciaService service) {
        this.service = service;
    }
      
 @GetMapping
    
      public ResponseEntity obtainAllCliente() {
        List<GenAgencia> genagencias = this.service.listAll();

        try {
            return ResponseEntity.ok(genagencias);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    
}
