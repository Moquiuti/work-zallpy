/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.repostory;

import br.com.zallpy.aplication.entidades.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author moquiuti
 */
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Associado findId(@Param("p0") Long p0);
}
