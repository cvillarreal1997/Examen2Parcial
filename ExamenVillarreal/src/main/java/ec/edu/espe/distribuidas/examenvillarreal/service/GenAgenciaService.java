/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.service;

import ec.edu.espe.distribuidas.examenvillarreal.dao.GenAgenciaRepository;
import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author terry
 */
@Service
@Slf4j
public class GenAgenciaService {
     private final GenAgenciaRepository genagenciaRepo;

    public GenAgenciaService(GenAgenciaRepository genagenciaRepo) {
        this.genagenciaRepo = genagenciaRepo;

    }
    
      public List<GenAgencia> listAll() {
        return this.genagenciaRepo.findAll();
    }
    
}
