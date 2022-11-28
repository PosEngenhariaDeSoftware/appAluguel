package br.edu.infnet.appaluguel.modelo.entidade;

import br.edu.infnet.appaluguel.modelo.entidade.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "aluguel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private int periodoDias;
    private BigDecimal valorAluguel;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataInicio;

    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "aluguel", fetch = FetchType.EAGER)
    private List<Equipamento> equipamentos;
}
