/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.as;

import br.com.zallpy.aplication.entidades.Sessao;
import br.com.zallpy.aplication.repostory.SessaoRepository;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author moquiuti
 */
@Service
public class SessaoAS {

    private final SessaoRepository repository;

    public SessaoAS(SessaoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity create(Sessao sessao) {
        if (Objects.isNull(sessao.getFim())) {
            LocalDateTime dataHoraSP = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Sao_Paulo"));
            sessao.setFim(dataHoraSP.plusSeconds(60));
        }
        if (Objects.isNull(sessao.getPauta())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe a pauta da sessão!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(sessao));
    }
}
