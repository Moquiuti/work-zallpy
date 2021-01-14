/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.resources;

import br.com.zallpy.aplication.as.AssociadoAS;
import br.com.zallpy.aplication.entidades.Associado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class AssociadoResource {

    @Autowired
    private AssociadoAS associadoService;

    @GetMapping(path = {"/associado"}, produces = "application/json")
    public ResponseEntity<ResponseEntity<List<Associado>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(associadoService.findAll());
    }

    @RequestMapping(value = "/associado", method = RequestMethod.POST)
    public ResponseEntity<Associado> create(@RequestBody Associado associado) {
        return associadoService.create(associado);
    }

}
