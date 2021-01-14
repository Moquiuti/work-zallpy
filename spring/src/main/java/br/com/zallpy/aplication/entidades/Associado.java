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
@Table(name = "associado")
@NamedQueries({
    @NamedQuery(name = "Associado.findId", query = "FROM Associado WHERE id = :p0")
})
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 250)
    private String nome;

}
