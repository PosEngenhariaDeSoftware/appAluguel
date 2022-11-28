package br.edu.infnet.appaluguel.modelo.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "equipamento")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdEquipamento;

    private String nome;

    private BigDecimal valorCompra;

    private BigDecimal valorUnitarioAluguel;

    private int quantidade;

    @ManyToOne(targetEntity = Aluguel.class)
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;
}
