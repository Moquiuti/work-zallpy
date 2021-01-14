package br.com.zallpy.aplication.entidades.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Moquiuti
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VotacaoDTO implements Serializable {

    private Long associado;

    private Long sessao;

    private String voto;
}
