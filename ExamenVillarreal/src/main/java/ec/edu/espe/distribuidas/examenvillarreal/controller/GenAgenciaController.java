/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.controller;

import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import ec.edu.espe.distribuidas.examenvillarreal.service.GenAgenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author terry
 */
@RequestMapping("/api/genagencia")
@RestController
@Slf4j
public class GenAgenciaController {

    private final GenAgenciaService service;

    public GenAgenciaController(GenAgenciaService service) {

        this.service = service;

    }

    @GetMapping
    @ApiOperation(value = "Listar Agencias", notes = "Retorna todas "
            + "las agencias")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Muestra todas las"
                + " agencias")
    })
    public ResponseEntity listarTodos() {
        List<GenAgencia> agencia = this.service.listAll();
        return ResponseEntity.ok(agencia);
    }


    @PostMapping
    @ApiOperation(value = "Registrar una nueva agencia", notes = "Agrega"
            + "una nueva agencia a la base de datos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Agencia registrada"),
        @ApiResponse(code = 400, message = "Agencia no pudo ser "
                + "registrada")

    })
    public ResponseEntity crearAgencia(
            @RequestBody GenAgencia agencia) {

        try {

            log.info("Va a crear la agencia con la siguiente informacion:"
                    + " {}", agencia);
            this.service.createGenAgencia(agencia);
            return ResponseEntity.ok().build();

        } catch (Exception e) {

            log.error("Ocurrio un error al crear la agencia. "
                    + "{} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();

        }
    }

}
    
    
    

