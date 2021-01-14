/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.as;

import br.com.zallpy.aplication.entidades.Pauta;
import br.com.zallpy.aplication.repostory.PautaRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author moquiuti
 */
@Service
public class PautaAS {

    private final PautaRepository repository;

    public PautaAS(PautaRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity create(Pauta pauta) {
        if (pauta.getDescricao().isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe a descrição da pauta!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pauta));
    }

    public ResponseEntity<List<Pauta>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

}
