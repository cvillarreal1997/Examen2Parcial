/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.service;

import ec.edu.espe.distribuidas.examenvillarreal.dao.GenAgenciaRepository;
import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author terry
 */
@Service
@Slf4j
public class GenAgenciaService {

    private final GenAgenciaRepository agenciaRepo;

    public GenAgenciaService(GenAgenciaRepository agenciaRepo) {

        this.agenciaRepo = agenciaRepo;

    }

    public List<GenAgencia> listAll() {

        return this.agenciaRepo.findAll();

    }

    public List<GenAgencia> findByName(String nombre) {

        return agenciaRepo.findByNombreStartingWithOrderByNombre(nombre);

    }

    @Transactional 
    public void createGenAgencia(GenAgencia agencia) {

        if (agenciaRepo.existsByNombre(agencia.getNombre())) {

            throw new IllegalArgumentException("La agencia ya existe");

        } else {

            agenciaRepo.save(agencia);

        }
    }

}