package br.edu.infnet.appaluguel.modelo.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ferramenta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ferramenta extends Equipamento {

    private String nome;
    private Boolean eletrica;
}
