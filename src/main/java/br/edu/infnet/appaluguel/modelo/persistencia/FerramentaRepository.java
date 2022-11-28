package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FerramentaRepository extends JpaRepository<Ferramenta, Long> {
}
