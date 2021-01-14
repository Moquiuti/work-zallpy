/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.resources;

import br.com.zallpy.aplication.as.PautaAS;
import br.com.zallpy.aplication.entidades.Pauta;
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
public class PautaResource {

    @Autowired
    private PautaAS pautaService;

    @GetMapping(path = {"/pauta"}, produces = "application/json")
    public ResponseEntity<ResponseEntity<List<Pauta>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pautaService.findAll());
    }

    @RequestMapping(value = "/pauta", method = RequestMethod.POST)
    public ResponseEntity<Pauta> create(@RequestBody Pauta pauta) {
        return pautaService.create(pauta);
    }

}
