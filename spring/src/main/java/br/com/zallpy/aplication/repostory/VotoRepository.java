/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.repostory;

import br.com.zallpy.aplication.entidades.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author moquiuti
 */
public interface VotoRepository extends JpaRepository<Votacao, Long> {

    public Votacao associadoPauta(@Param("p0") Long id, @Param("p1") Long id0);

}
