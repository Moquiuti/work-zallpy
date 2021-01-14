/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.resources;

import br.com.zallpy.aplication.as.VotoAS;
import br.com.zallpy.aplication.entidades.Votacao;
import br.com.zallpy.aplication.entidades.dto.VotacaoDTO;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moquiuti
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/"})
public class VotoResource {

    @Autowired
    private VotoAS votoService;

    @RequestMapping(value = "/voto", method = RequestMethod.POST)
    public ResponseEntity<Votacao> create(@RequestBody VotacaoDTO voto) throws IOException {
        return votoService.create(voto);
    }

    @GetMapping(path = {"/voto/{sessao}/favoravel"}, produces = "application/json")
    public ResponseEntity<Integer> findFavoravel(@PathVariable("sessao") Long sessao) {
        return votoService.findFavoravel(sessao);
    }
    
    @GetMapping(path = {"/voto/{sessao}/negado"}, produces = "application/json")
    public ResponseEntity<Integer> findNegado(@PathVariable("sessao") Long sessao) {
        return votoService.findNegado(sessao);
    }

}
