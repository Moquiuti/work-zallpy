/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.repostory;

import br.com.zallpy.aplication.entidades.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author moquiuti
 */
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Sessao findPauta(@Param("p0") Long p0);
    
    Sessao findId(@Param("p0") Long p0);

}
