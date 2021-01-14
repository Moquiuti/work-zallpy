/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.repostory;

import br.com.zallpy.aplication.entidades.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author moquiuti
 */
public interface PautaRepository extends JpaRepository<Pauta, Long> {
    
}
