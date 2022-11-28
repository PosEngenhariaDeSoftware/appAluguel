package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
