package br.com.zallpy.aplication.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
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
@Entity
@Table(name = "votacao")
@NamedQueries({
    @NamedQuery(name = "Votacao.associadoPauta", query = "FROM Votacao WHERE associado.id = :p0 and sessao.pauta.id = :p1"),
})
public class Votacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "data")
    private LocalDateTime dataVoto;

    @ManyToOne
    private Associado associado;

    @ManyToOne
    private Sessao sessao;
    
    @NotEmpty(message = "Voto não pode ser vazio")
    @Column(name = "voto", length = 3)
    private String voto;
}
