/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examenvillarreal.dao;
import ec.edu.espe.distribuidas.examenvillarreal.model.GenAgencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author terry
 */
public interface GenAgenciaRepository extends JpaRepository<GenAgencia, String> {

    List<GenAgencia> findByNombreStartingWithOrderByNombre(String nombre);

    Boolean existsByNombre(String nombre);
}