package br.edu.infnet.appaluguel.modelo.entidade;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
    private boolean whatsapp;

//    @OneToMany(mappedBy = "cliente")
//    private List<Aluguel> alugueis;
}
