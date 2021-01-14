package br.com.zallpy.aplication.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
@Entity
@Table(name = "pauta")
@NamedQueries({
    @NamedQuery(name = "Pauta.findId", query = "FROM Pauta WHERE id = :p0")
})
public class Pauta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Descrição não pode ser vazio")
    @Column(name = "descricao", length = 1000)
    private String descricao;

}
