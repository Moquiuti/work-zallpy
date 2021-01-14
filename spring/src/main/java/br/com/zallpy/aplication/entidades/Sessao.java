package br.com.zallpy.aplication.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "sessao")
@NamedQueries({
    @NamedQuery(name = "Sessao.findPauta", query = "FROM Sessao WHERE pauta.id = :p0"),
    @NamedQuery(name = "Sessao.findId", query = "FROM Sessao WHERE id = :p0")
})
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fim")
    private LocalDateTime fim;

    @OneToOne
    private Pauta pauta;

}
