package br.edu.infnet.appaluguel.modelo.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "betoneira")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Betoneira extends Equipamento{

    private String marca;
    private LocalDateTime dataAquisicao;
    private String observacao;
}
