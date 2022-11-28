package br.edu.infnet.appaluguel.modelo.persistencia;

import br.edu.infnet.appaluguel.modelo.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpf(String cpf);
}
