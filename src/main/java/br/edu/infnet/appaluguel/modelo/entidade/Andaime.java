package br.edu.infnet.appaluguel.modelo.entidade;

import br.edu.infnet.appaluguel.modelo.entidade.enums.TipoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "andaime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Andaime extends Equipamento{

    @Enumerated(EnumType.STRING)
    private TipoEnum tipoEnum;
}
