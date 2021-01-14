/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.resources;

import br.com.zallpy.aplication.as.SessaoAS;
import br.com.zallpy.aplication.entidades.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class SessaoResource {

    @Autowired
    private SessaoAS sessaoService;

    @RequestMapping(value = "/sessao", method = RequestMethod.POST)
    public ResponseEntity<Sessao> create(@RequestBody Sessao sessao) {
        return sessaoService.create(sessao);
    }

}
