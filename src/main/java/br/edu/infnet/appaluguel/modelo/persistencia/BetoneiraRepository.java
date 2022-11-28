package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Betoneira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetoneiraRepository extends JpaRepository<Betoneira, Long> {
}
