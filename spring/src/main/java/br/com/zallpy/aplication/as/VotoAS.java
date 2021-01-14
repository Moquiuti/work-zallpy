/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zallpy.aplication.as;

import br.com.zallpy.aplication.entidades.Associado;
import br.com.zallpy.aplication.entidades.Sessao;
import br.com.zallpy.aplication.entidades.Votacao;
import br.com.zallpy.aplication.entidades.dto.VotacaoDTO;
import br.com.zallpy.aplication.repostory.AssociadoRepository;
import br.com.zallpy.aplication.repostory.SessaoRepository;
import br.com.zallpy.aplication.repostory.VotoRepository;
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
public class VotoAS {

    private final VotoRepository repository;

    private final AssociadoRepository repositoryAssociado;

    private final SessaoRepository repositorySessao;

    public VotoAS(VotoRepository repository,
            AssociadoRepository repositoryAssociado,
            SessaoRepository repositorySessao) {
        this.repository = repository;
        this.repositoryAssociado = repositoryAssociado;
        this.repositorySessao = repositorySessao;
    }

    public ResponseEntity create(VotacaoDTO votacao) {
        if (votacao.getVoto().isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe seu voto!");
        }
        if (votacao.getVoto().length() != 3) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe sim ou não!");
        }
        if (Objects.isNull(votacao.getAssociado())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe quem é o associado votante!");
        }
        if (Objects.isNull(votacao.getSessao())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Informe a sessão!");
        }

        Associado associado = (Associado) repositoryAssociado.findId(votacao.getAssociado());
        Sessao sessao = (Sessao) repositorySessao.findId(votacao.getSessao());

        if (sessao.getFim().isBefore(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Sao_Paulo")))) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sessão encerrada!");
        }

        Votacao voto = Votacao.builder().dataVoto(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Sao_Paulo"))).associado(associado).sessao(sessao).voto(votacao.getVoto()).build();
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(voto));
    }
}
