/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.as;

import br.com.zallpy.aplication.entidades.Associado;
import br.com.zallpy.aplication.repostory.AssociadoRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author moquiuti
 */
@Service
public class AssociadoAS {

    private final AssociadoRepository repository;

    public AssociadoAS(AssociadoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity create(Associado associado) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(associado));
    }

    public ResponseEntity<List<Associado>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

}
